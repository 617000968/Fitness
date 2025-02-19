package com.liuhuang.fitness.controller;

import com.liuhuang.fitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {

    @Autowired
    private UserService userService;
    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id){
        userService.delete(id);
        return "redirect:/login";
    }
}
