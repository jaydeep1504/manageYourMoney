package com.app.manageYourMoney.controller;

import com.app.manageYourMoney.data.entity.UserDetails;
import com.app.manageYourMoney.data.repository.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    private UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @GetMapping("/getalluser")
    public String getAllUser(Model model){
        model.addAttribute("users",this.userRepo.findAll());
        return "getalluser";
    }
}
