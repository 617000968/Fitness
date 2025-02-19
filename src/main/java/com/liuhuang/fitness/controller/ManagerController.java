package com.liuhuang.fitness.controller;

import com.liuhuang.fitness.model.Food;
import com.liuhuang.fitness.model.Sport;
import com.liuhuang.fitness.model.User;
import com.liuhuang.fitness.service.FoodService;
import com.liuhuang.fitness.service.ManagerService;
import com.liuhuang.fitness.service.SportService;
import com.liuhuang.fitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private UserService userService;
    @Autowired
    private SportService sportService;
    @Autowired
    private FoodService foodService;
    @GetMapping("/login")
    public String login(){
        return "manageLogin";
    }

    @PostMapping("/login")
    public String manageLogin(@RequestParam("username") String username,
                              @RequestParam("password") String password){
        if (managerService.validate(username, password)){
            return "manage";
        } else {
            return "manageLogin";
        }
    }

    @GetMapping("/getAllUser")
    public String getAllUser(Model model) {
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList", userList);
        return "/getAllUser";
    }
    @GetMapping("/getAllSport")
    public String getAllSport(Model model) {
        List<Sport> sportList = sportService.getAllSport();
        model.addAttribute("sportList", sportList);
        return "/getAllSport";
    }
    @GetMapping("/getAllFood")
    public String getAllFood(Model model) {
        List<com.liuhuang.fitness.model.Food> foodList = foodService.findAll();
        model.addAttribute("foodList", foodList);
        return "/getAllFood";
    }
    @GetMapping("/deleteFood")
    public String deleteFood(@RequestParam("id") int id) {
        foodService.deleteById(id);
        return "redirect:/manage/getAllFood";
    }
    @GetMapping("/deleteSport")
    public String deleteSport(@RequestParam("id") int id){
        sportService.deleteById(id);
        return "redirect:/manage/getAllSport";
    }
    @PostMapping(value = "/updateFood")
    public String saveFood(@RequestBody Food food) {

        System.out.println(food);
        try {
            foodService.save(food);
            return "redirect:/manage/getAllFood";
        } catch (Exception e) {
            return "redirect:/manage/getAllFood";
        }
    }
    @PostMapping("/updateSport")
    public String updateSport(@RequestBody Sport sport){
        sportService.save(sport);
        return "redirect:/manage/getAllSport";
    }
    @PostMapping("/addFood")
    public String addFood(@RequestParam("name") String name,
                          @RequestParam("protein") float protein,
                          @RequestParam("carbohydrates") float carbohydrates,
                          @RequestParam("fat") float fat,
                          @RequestParam("heat") float heat){
        Food food = new Food();
        food.setName(name);
        food.setProtein(protein);
        food.setCarbohydrates(carbohydrates);
        food.setFat(fat);
        food.setHeat(heat);
        foodService.save(food);
        return "redirect:/manage/getAllFood";
    }
    @PostMapping("addSport")
    public String addSport(@RequestParam("name") String name,
                           @RequestParam("type")String type){
        Sport sport = new Sport();
        sport.setName(name);
        sport.setType(type);
        sportService.save(sport);
        return "redirect:/manage/getAllSport";
    }
}
