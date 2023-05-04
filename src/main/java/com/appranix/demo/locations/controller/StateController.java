package com.appranix.demo.locations.controller;

import com.appranix.demo.locations.domain.State;
import com.appranix.demo.locations.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping("/list")
    public List<State> list() {
        return stateService.list();
    }
}
