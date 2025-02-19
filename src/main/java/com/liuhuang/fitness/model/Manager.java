package com.liuhuang.fitness.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Manager")
@Data
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
}
