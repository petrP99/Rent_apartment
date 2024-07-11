package com.example.architect_module.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArchitectController {

    @GetMapping("/test")
    public String getInfo() {
        return "Test";
    }
}
