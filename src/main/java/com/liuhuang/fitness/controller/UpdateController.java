package com.liuhuang.fitness.controller;

import com.liuhuang.fitness.model.Information;
import com.liuhuang.fitness.model.Recording;
import com.liuhuang.fitness.model.User;
import com.liuhuang.fitness.service.InformationService;
import com.liuhuang.fitness.service.RecordingService;
import com.liuhuang.fitness.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class UpdateController {

    @Autowired
    private InformationService informationService;
    @Autowired
    private UserService userService;
    @Autowired
    private RecordingService recordingService;

    @GetMapping("/update")
    public String update(HttpSession session, Model model){
        Information information = (Information) session.getAttribute("information");
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        model.addAttribute("information",information);
        return "update";
    }

    @PostMapping("/update")
    public String update(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password){
        User user = userService.getUser(username);
        user.setPassword(password);
        System.out.println(username);
        System.out.println(password);
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/recording")
    public String recording(HttpSession session, Model model){
        Information information = (Information) session.getAttribute("information");
        model.addAttribute("information",information);
        return "recording";
    }
    @PostMapping("/recording")
    public String recording(@RequestParam(name = "username") String username,
                            @RequestParam(name = "height") String height1,
                            @RequestParam(name = "weight") String weight1){
        double height = Double.parseDouble(height1);
        double weight = Double.parseDouble(weight1);
        LocalDate date = LocalDate.now();
        float bmi = RegisterController.getBMI(weight,height);
        Recording recording = new Recording();
        recording.setUsername(username);
        recording.setHeight(height);
        recording.setWeight(weight);
        recording.setRecordingTime(date.toString());
        recording.setBmi(bmi);
        recordingService.save(recording);
        return "login";
    }
}