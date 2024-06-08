package com.thehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RotaController {

    @GetMapping("/")
    public String hello(Model model) {
        return "index";
    }
}
