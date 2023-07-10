package com.app.manageYourMoney.webservice;

import com.app.manageYourMoney.data.entity.UserDetails;
import com.app.manageYourMoney.data.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
public class WebServiceController {

    private UserRepository userRepository;
    public WebServiceController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping(path = "/getuser")
    public List<UserDetails> getAllUser(){
        return this.userRepository.findAll();
    }
    @PostMapping(path = "/adduser")
    public String addUser(@RequestBody UserDetails userDetails){
        this.userRepository.save(userDetails);
        return userDetails.toString()+" added.";
    }
    @DeleteMapping(path = "/deleteuser/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        this.userRepository.deleteById(id);
        return "User "+id+" deleted.";
    }
}
