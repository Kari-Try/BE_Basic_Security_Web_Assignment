package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String showForm() {
        return "greetingForm";    // templates/greetingForm.html
    }

    @PostMapping("/greeting")
    public String submitForm(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";        // templates/greeting.html
    }
}