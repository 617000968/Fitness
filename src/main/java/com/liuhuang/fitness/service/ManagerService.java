package com.liuhuang.fitness.service;

import com.liuhuang.fitness.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    public boolean validate(String username,String password){
        return managerRepository.findByUsernameAndPassword(username,password) != null;
    }

}
