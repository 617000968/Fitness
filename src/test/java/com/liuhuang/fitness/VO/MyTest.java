package com.liuhuang.fitness.VO;

import com.liuhuang.fitness.service.RecordingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyTest {

    @Autowired
    private RecordingService recordingService;
    @Test
    public void test(){
        System.out.println(recordingService.getRecordingByUsername("admin"));
    }
}
