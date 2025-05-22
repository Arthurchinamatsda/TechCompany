package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerHome {
    
    @GetMapping("/")
    public String index() {
        return "IndexHome";  // vai para src/main/resources/templates/index.html
    }
}
