package com.liuhuang.fitness.handler;

import com.liuhuang.fitness.exception.UsernameAlreadyExistsException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public String handleUsernameAlreadyExistsException(UsernameAlreadyExistsException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "error";
    }
}