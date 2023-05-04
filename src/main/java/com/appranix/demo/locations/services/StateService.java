package com.appranix.demo.locations.services;

import com.appranix.demo.locations.domain.State;
import com.appranix.demo.locations.repositories.UsStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired
    private UsStateRepository usStateRepository;

    public List<State> list() {
        return usStateRepository.findAll();
    }
}
