package com.example.Wood.controllers;

import com.example.Wood.dtos.SubscribeDto;
import com.example.Wood.services.SubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SubscribeController {
    private final SubscribeService subscribeService;
    @PostMapping("/subscribe")
    public String subscribe(@ModelAttribute SubscribeDto subscribeDto){
        subscribeService.subscribe(subscribeDto);
        return "redirect:/";

    }
}
