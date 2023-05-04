package com.appranix.demo.locations.controller;

import com.appranix.demo.locations.domain.BuildInfo;
import com.appranix.demo.locations.services.DbBuildInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/db/build")
public class DbBuildInfoController {

    @Autowired
    private DbBuildInfoService buildInfoService;

    @PostMapping("/")
    public void add(@RequestBody BuildInfo buildInfo) {
        buildInfoService.add(buildInfo);
    }

    @GetMapping("/{id}")
    public BuildInfo describe(@PathVariable String id) {
        var result =  buildInfoService.find(id);
        return result.orElseThrow(ResourceNotFoundException::new);
    }

    @GetMapping("/")
    public List<BuildInfo> list() {
        return buildInfoService.list();
    }
}
