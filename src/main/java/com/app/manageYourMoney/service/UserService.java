package com.app.manageYourMoney.service;

import com.app.manageYourMoney.data.entity.UserDetails;
import com.app.manageYourMoney.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDetails> getAllUsers(){
        return userRepository.findAll();
    }

    public void saveUser(UserDetails userDetails){
        userRepository.save(userDetails);
    }

    public void deleteUserById(int id){
        userRepository.deleteById(id);
    }

    public UserDetails getUserById(int id) {
        return userRepository.getReferenceById(id);
    }
}
