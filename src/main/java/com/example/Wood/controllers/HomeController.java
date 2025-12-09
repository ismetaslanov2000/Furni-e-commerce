package com.example.Wood.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public  String home(){
        return "index.html";
    }
    @GetMapping("/about")
    public  String about(){
        return "about.html";
    }
    @GetMapping("/blog")
    public  String blog(){
        return "blog.html";
    }
    @GetMapping("/services")
    public  String services(){
        return "services.html";
    }
    @GetMapping("/contact")
    public  String contact(){
        return "contact.html";
    }
    @GetMapping("/cart")
    public  String cart(){
        return "cart.html";
    }
}
