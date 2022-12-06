package com.example.bitcoinShopPractice.user.repository;

import com.example.bitcoinShopPractice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepository {

    @Autowired
    UserMapper userMapper;

    public int signup(HashMap<String,String> userInfo){
            return userMapper.signup(userInfo);
    }

    public HashMap<String,String> login(HashMap<String,String> userInfo){
        return userMapper.login(userInfo);
    }

    public int charge(HashMap<String,String> chargeInfo){
        return userMapper.charge(chargeInfo);
    }

    public long getUserPayment(String email){
        return userMapper.getUserPayment(email);
    }

    public int buyCoin(HashMap<String,String> buyInfo){
        return userMapper.buyCoin(buyInfo);
    }

    public double getBuyCoin(String email){
        return userMapper.getBuyCoin(email);
    }

}
