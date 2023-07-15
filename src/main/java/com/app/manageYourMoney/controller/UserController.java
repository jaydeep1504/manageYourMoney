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
    @GetMapping("/getalluser")
    public String getAllUser(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "getalluser";
    }
    @GetMapping("/adduser")
    public String addUser(UserDetails userDetails){
        return "adduser";
    }

    @PostMapping("/save")
    public String saveUserDetails(@ModelAttribute UserDetails userDetails){
        System.out.println(userDetails);
        userService.saveUser(userDetails);
        return "redirect:/getalluser";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        userService.deleteUserById(id);
        return "redirect:/getalluser";
    }

    @RequestMapping("/editUser/{id}")
    public String editUser(@PathVariable int id,Model model){
        String genderSelectMale="";
        String genderSelectFemale="";
        String genderSelectUnspecified="";
        String isAdmin="";
        String isGeneral="";

        switch(userService.getUserById(id).getGender()){
            case "Male":
                genderSelectMale="selected";
                break;
            case "Female":
                genderSelectFemale="selected";
                break;
            case "Unspecified":
                genderSelectUnspecified = "selected";
                break;
        }

        switch (userService.getUserById(id).getUserType()){
            case "Admin":
                isAdmin="checked";
                break;
            case "General":
                isGeneral="checked";
                break;
        }

        model.addAttribute("genderSelectMale",genderSelectMale);
        model.addAttribute("genderSelectFemale",genderSelectFemale);
        model.addAttribute("genderSelectUnspecified",genderSelectUnspecified);

        model.addAttribute("isAdmin",isAdmin);
        model.addAttribute("isGeneral",isGeneral);

        model.addAttribute("user", userService.getUserById(id));

        System.out.println(model.getAttribute("genderSelectMale"));
        System.out.println(model.getAttribute("genderSelectFemale"));
        System.out.println(model.getAttribute("genderSelectUnspecified"));
        System.out.println(model.getAttribute("isAdmin"));
        System.out.println(model.getAttribute("isGeneral"));


        return "editUser";
    }
}
