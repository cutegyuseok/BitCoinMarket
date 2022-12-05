package com.example.bitcoinShopPractice.user.service;

import com.example.bitcoinShopPractice.user.DTO.userDTO;
import com.example.bitcoinShopPractice.user.repository.userRepository;
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

    public userDTO login(HashMap<String,String> userInfo){
        try {
            HashMap<String,String> user = userRepository.login(userInfo);
            return new userDTO(user.get("email"),user.get("name"),user.get("phone"),user.get("address"),user.get("detail"));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
