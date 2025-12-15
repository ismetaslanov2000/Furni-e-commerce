package com.example.Wood.controllers;

import com.example.Wood.dtos.RegisterDto;
import com.example.Wood.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;



    @GetMapping("/register")
    public String register(){
        return "register.html";
    }
    @GetMapping("/login")
    public String login(){
        return "login.html";
    }
    @PostMapping("/register")
    public String register(RegisterDto registerDto){
        boolean result=userService.registerUser(registerDto);
        if (result){
            return "redirect:/register";
        }
        return  "redirect:/register";
    }
}
