package com.liuhuang.fitness.repository;

import com.liuhuang.fitness.model.Recording;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordingRepository extends JpaRepository<Recording, Integer> {
    List<Recording> getRecordingByUsername(String username);
}
