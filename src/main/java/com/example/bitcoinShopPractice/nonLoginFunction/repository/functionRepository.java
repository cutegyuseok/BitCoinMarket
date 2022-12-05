package com.example.bitcoinShopPractice.nonLoginFunction.repository;

import com.example.bitcoinShopPractice.mapper.functionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class functionRepository {

    @Autowired
    functionMapper functionMapper;

    public int requestCall(HashMap<String,String> requestInfo){
        return functionMapper.requestCall(requestInfo);
    }

    public int subscribe(String email){
        return functionMapper.subscribe(email);
    }
}
