package com.liuhuang.fitness.controller;

import com.liuhuang.fitness.model.*;
import com.liuhuang.fitness.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    @Autowired
    private FoodService foodService;
    @Autowired
    private InformationService informationService;

    @Autowired
    private SportService sportService;
    @Autowired
    private RecordingService recordingService;
    @GetMapping("/login")
    public String showLoginForm(){return "login";}

    @PostMapping("/login")
    public String login(String username, String password, Model model,HttpSession session){
        User user = userService.getUser(username);
        if (user.getPassword().equals(password)){
            Information information = informationService.getInformationByUsername(username);
            String type;
            if (information.getTarget().equals("增肌")){
                type = "无氧";
            } else {
                type = "有氧";
            }
            session.setAttribute("information", information);
            session.setAttribute("user", user);
            List<Recording> recordList = recordingService.getRecordingByUsername(username);
            List<Sport> sportList = sportService.getSportByType(type);
            List<Food> foodList = foodService.findAll();
            model.addAttribute("foodList", foodList);
            model.addAttribute("sportList", sportList);
            model.addAttribute("recordList", recordList);
            model.addAttribute("information", information);
            return "welcome";
        }else{
            model.addAttribute("error","用户名或密码错误！");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpSession session){
        model.addAttribute("error","您已退出登录！");
        session.invalidate();
        return "redirect:/login";
    }
}
