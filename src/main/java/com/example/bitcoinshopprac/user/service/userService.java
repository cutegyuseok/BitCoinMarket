package com.example.bitcoinshopprac.user.service;

import com.example.bitcoinshopprac.user.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class userService {

    @Autowired
    userRepository userRepository;

    public int signup(HashMap<String, String> userInfo) {

        try {
            userRepository.signup(userInfo);
            return 1;
        }catch (Exception e){
            return -1;
        }
    }

    public String login(HashMap<String,String> userInfo){
        try {
            return userRepository.login(userInfo);
        }catch (Exception e){
            return null;
        }
    }
}
