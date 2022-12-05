package com.example.bitcoinShopPractice.user.repository;

import com.example.bitcoinShopPractice.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class userRepository {

    @Autowired
    userMapper userMapper;

    public int signup(HashMap<String,String> userInfo){
            return userMapper.signup(userInfo);
    }

    public HashMap<String,String> login(HashMap<String,String> userInfo){
        return userMapper.login(userInfo);
    }
}
