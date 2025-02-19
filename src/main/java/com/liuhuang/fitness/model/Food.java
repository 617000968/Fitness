package com.liuhuang.fitness.model;


import jakarta.persistence.*;
import lombok.Data;

@Table(name = "food")
@Entity
@Data
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "protein")
    private float protein;
    @Column(name = "carbohydrates")
    private float carbohydrates;
    @Column(name = "fat")
    private float fat;
    @Column(name = "heat")
    private float heat;

}
