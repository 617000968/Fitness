package com.liuhuang.fitness.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sport")
@Data
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
}
