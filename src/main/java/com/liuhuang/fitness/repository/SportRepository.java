package com.liuhuang.fitness.repository;

import com.liuhuang.fitness.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportRepository extends JpaRepository<Sport, Integer> {

    List<Sport> getSportByType(String type);
}
