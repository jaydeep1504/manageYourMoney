package com.app.manageYourMoney.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mymcontroller {
    @GetMapping("/")
    public String getMYMHome(){
        return "index";
    }
}
