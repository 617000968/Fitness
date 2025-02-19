package com.liuhuang.fitness.service;

import com.liuhuang.fitness.model.Sport;
import com.liuhuang.fitness.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportService {
    @Autowired
    private SportRepository sportRepository;
    public List<Sport> getSportByType(String type){
        return sportRepository.getSportByType(type);
    }

    public List<Sport> getAllSport() {
        return sportRepository.findAll();
    }

    public void deleteById(int id) {
        sportRepository.deleteById(id);
    }

    public void save(Sport sport) {
        sportRepository.save(sport);
    }
}
