package com.app.manageYourMoney.controller;

import com.app.manageYourMoney.data.repository.UserRepository;
import com.app.manageYourMoney.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getalluser")
    public String getAllUser(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "getalluser";
    }
}
