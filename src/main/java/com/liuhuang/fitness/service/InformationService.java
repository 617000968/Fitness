package com.liuhuang.fitness.service;


import com.liuhuang.fitness.model.Information;
import com.liuhuang.fitness.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationService {
    @Autowired
    private InformationRepository informationRepository;

    public void save(Information information) {
        informationRepository.save(information);
    }

    public Information getInformationByUsername(String username) {
        return informationRepository.findByUsername(username);
    }
}
