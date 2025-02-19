package com.liuhuang.fitness.repository;

import com.liuhuang.fitness.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    Manager findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
