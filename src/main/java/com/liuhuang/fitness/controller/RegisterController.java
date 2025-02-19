package com.liuhuang.fitness.controller;

import com.liuhuang.fitness.exception.UsernameAlreadyExistsException;
import com.liuhuang.fitness.model.Information;
import com.liuhuang.fitness.model.Recording;
import com.liuhuang.fitness.model.User;
import com.liuhuang.fitness.service.InformationService;
import com.liuhuang.fitness.service.RecordingService;
import com.liuhuang.fitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private InformationService informationService;
    @Autowired
    private RecordingService recordingService;
    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String register(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "sex") String sex,
            @RequestParam(name = "height") double height,
            @RequestParam(name = "weight") double weight,
            @RequestParam(name = "age") int age,
            @RequestParam(name = "target") String target,
            Model model) throws UsernameAlreadyExistsException {
        User existingUser = userService.getUser(username);
        if (existingUser != null){
            throw new UsernameAlreadyExistsException("用户名已存在！");
        }
        float bmi = getBMI(weight, height);
        LocalDate date = LocalDate.now();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.register(user);
        Information information = new Information();
        information.setUsername(username);
        information.setName(name);
        information.setSex(sex);
        information.setHeight(height);
        information.setWeight(weight);
        information.setAge(age);
        information.setBmi(bmi);
        information.setTarget(target);
        informationService.save(information);
        Recording recording = new Recording();
        recording.setUsername(username);
        recording.setHeight(height);
        recording.setWeight(weight);
        recording.setBmi(bmi);
        recording.setRecordingTime(date.toString());
        recordingService.save(recording);
        model.addAttribute("message", "注册成功！");
        return "redirect:/login";
    }

    public static float getBMI(double weight, double height) {
        return (float) (weight / Math.pow(height / 100, 2));
    }

}