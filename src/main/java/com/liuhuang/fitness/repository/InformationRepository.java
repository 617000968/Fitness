package com.liuhuang.fitness.repository;

import com.liuhuang.fitness.model.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationRepository extends JpaRepository<Information, Integer> {
    Information findByUsername(String username);
}
