package com.thehouse.controller;

import jakarta.persistence.Entity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RotaController {
    @GetMapping("/")
    public String view() {
        return "<h1>Hello World!</h1>";

    }
}
