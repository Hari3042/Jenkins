package com.appranix.demo.locations.services;

import com.appranix.demo.locations.AppFeatures;
import com.appranix.demo.locations.domain.BuildInfo;
import com.appranix.demo.locations.repositories.BuildInfoJpaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.togglz.core.manager.FeatureManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FileBuildInfoService {


    @Autowired
    FeatureManager manager;

    @Value("${feature.file.path}")
    private String directoryPath;

    @Autowired
    private BuildInfoJpaRepository buildInfoJpaRepository;

    public void add(BuildInfo buildInfo) {
         buildInfo.setCreatedAt(new Date());

         if (manager.isActive(AppFeatures.FILE)) {
             try {
                 writeJsonToFile(buildInfo);
             } catch (IOException e) {
                 //log.debug("failed conversion: object to Json", e);
             }
         }
    }

    private void writeJsonToFile(BuildInfo buildInfo) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String objJackson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(buildInfo);

        var pathName = new File(directoryPath, buildInfo.getId());

        BufferedWriter writer = new BufferedWriter(new FileWriter(pathName));
        writer.write(objJackson);

        writer.close();
    }

    private Optional<BuildInfo> readFromFile(String id) {
        var pathName = new File(directoryPath, id);
        ObjectMapper objectMapper = new ObjectMapper();
        BuildInfo response;
        try {
            response = objectMapper.readValue(pathName, BuildInfo.class);
            return Optional.of(response);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<BuildInfo> find(String id) {
        return readFromFile(id);
    }

    public Optional<BuildInfo> find(File file) {
        return readFromFile(file.getName());
    }

    public List<BuildInfo> list() {
        return Stream.of(new File(directoryPath).listFiles())
                .filter(file -> !file.isDirectory())
                .map(this::find)
                .filter(value -> value.isPresent())
                .map(value -> value.get())
                .collect(Collectors.toList());
    }


}
