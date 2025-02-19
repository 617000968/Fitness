package com.liuhuang.fitness.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "information")
@Entity
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "name")
    private String name;
    @Column(name = "sex")
    private String sex;
    @Column(name = "height")
    private double height;
    @Column(name = "weight")
    private double weight;
    @Column(name = "age")
    private int age;
    @Column(name = "bmi")
    private float bmi;
    @Column(name = "target")
    private String target;
}
