package com.liuhuang.fitness.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "recording")
@Entity
@Data
public class Recording {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "height")
    private double height;
    @Column(name = "weight")
    private double weight;
    @Column(name = "bmi")
    private float bmi;
    @Column(name = "recording_time")
    private String recordingTime;
}
