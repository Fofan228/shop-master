package com.example.shoppinglist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String index() {
        return "shopping-list";
    }

    @RequestMapping("/add")
    public String add() {
        return "add-product";
    }
}
