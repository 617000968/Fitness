package com.liuhuang.fitness.service;

import com.liuhuang.fitness.model.User;
import com.liuhuang.fitness.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    public void register(User user) {
        userRepository.save(user);
    }


    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
