package com.appranix.demo.locations.services;

import com.appranix.demo.locations.AppFeatures;
import com.appranix.demo.locations.domain.BuildInfo;
import com.appranix.demo.locations.repositories.BuildInfoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.togglz.core.manager.FeatureManager;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DbBuildInfoService {

    @Autowired
    FeatureManager manager;

    @Value("${feature.file.path}")
    private String directoryPath;

    @Autowired
    private BuildInfoJpaRepository buildInfoJpaRepository;

    public void add(BuildInfo buildInfo) {
         buildInfo.setCreatedAt(new Date());

         if (manager.isActive(AppFeatures.DATABASE)) {
            buildInfoJpaRepository.save(buildInfo);
         }
    }

    public Optional<BuildInfo> find(String id) {
        return buildInfoJpaRepository.findById(id);
    }

    public List<BuildInfo> list() {
        return buildInfoJpaRepository.findAll();
    }
}
