package com.example.bitcoinshopprac.user.repository;

import com.example.bitcoinshopprac.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;

@Repository
public class userRepository {

    @Autowired
    userMapper userMapper;

    public int signup(HashMap<String,String> userInfo){
            return userMapper.signup(userInfo);
    }

    public String login(HashMap<String,String> userInfo){
        return userMapper.login(userInfo);
    }
}
