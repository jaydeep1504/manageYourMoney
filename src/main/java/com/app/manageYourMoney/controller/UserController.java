package com.app.manageYourMoney.controller;

import com.app.manageYourMoney.data.entity.UserDetails;

import com.app.manageYourMoney.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getallusers")
    public String getAllUser(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "getallusers";
    }
    @GetMapping("/adduser")
    public String addUser(UserDetails userDetails){
        return "adduser";
    }

    @PostMapping("/saveuser")
    public String saveUserDetails(@ModelAttribute UserDetails userDetails){
        //System.out.println(userDetails);
        userService.saveUser(userDetails);
        return "redirect:/getallusers";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        userService.deleteUserById(id);
        return "redirect:/getallusers";
    }

    @RequestMapping("/editUser/{id}")
    public String editUser(@PathVariable int id,Model model){

        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }
}
