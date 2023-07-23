package com.app.manageYourMoney.webservice;

import com.app.manageYourMoney.data.entity.ItemDetails;
import com.app.manageYourMoney.data.entity.UserDetails;
import com.app.manageYourMoney.data.repository.UserRepository;
import com.app.manageYourMoney.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
public class WebServiceController {

	@Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ItemService itemService;
    
    @GetMapping(path = "/getuser")
    public List<UserDetails> getAllUser(){
        return this.userRepository.findAll();
    }
    
    @PostMapping(path = "/adduser")
    public String addUser(@RequestBody UserDetails userDetails) {
        this.userRepository.save(userDetails);
        return "addUser";
    }
    
    @PostMapping(path = "/additem")
    public String addItem(@RequestBody ItemDetails itemDetails) {
    	itemService.saveItem(itemDetails);
    	return "Item Added Successfully";
    }

}
