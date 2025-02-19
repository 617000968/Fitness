package com.liuhuang.fitness.service;

import com.liuhuang.fitness.model.Recording;
import com.liuhuang.fitness.repository.RecordingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordingService {
    @Autowired
    private RecordingRepository recordingRepository;

    public void save(Recording recording) {
        recordingRepository.save(recording);
    }

    public List<Recording> getRecordingByUsername(String username) {
        return recordingRepository.getRecordingByUsername(username);
    }
}
