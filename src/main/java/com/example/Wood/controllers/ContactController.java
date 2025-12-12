package com.example.Wood.controllers;

import com.example.Wood.dtos.ContactDto;
import com.example.Wood.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @PostMapping("/")
    public String addContact(@ModelAttribute("contact") ContactDto contactDto) {
        contactService.addContact(contactDto);
        return "redirect:/";
    }
}
