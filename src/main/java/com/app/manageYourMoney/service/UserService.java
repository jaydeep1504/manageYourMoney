package com.app.manageYourMoney.service;

import com.app.manageYourMoney.data.entity.UserDetails;
import com.app.manageYourMoney.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDetails> getAllUsers(){
        return userRepository.findAll();
    }
}
