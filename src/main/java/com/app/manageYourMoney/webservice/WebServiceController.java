package com.app.manageYourMoney.webservice;

import com.app.manageYourMoney.data.entity.UserDetails;
import com.app.manageYourMoney.data.repository.UserRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
public class WebServiceController {

    private UserRepo userRepo;
    public WebServiceController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @GetMapping(path = "/getuser")
    public List<UserDetails> getAllUser(){
        return this.userRepo.findAll();
    }
    @PostMapping(path = "/adduser")
    public String addUser(@RequestBody UserDetails userDetails){
        this.userRepo.save(userDetails);
        return userDetails.toString()+" added.";
    }
    @DeleteMapping(path = "/deleteuser/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        this.userRepo.deleteById(id);
        return "User "+id+" deleted.";
    }
}
