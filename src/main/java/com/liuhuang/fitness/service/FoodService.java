package com.liuhuang.fitness.service;

import com.liuhuang.fitness.model.Food;
import com.liuhuang.fitness.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;

    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    public void deleteById(int id) {
        foodRepository.deleteById(id);
    }

    public void save(Food food) {
        foodRepository.save(food);
    }
}
