package com.example.bitcoinShopPractice.nonLoginFunction.service;

import com.example.bitcoinShopPractice.nonLoginFunction.repository.FunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class FunctionService {

    @Autowired
    FunctionRepository functionRepository;

    public boolean requestCall(HashMap<String,String> requestInfo){
        try{
            return functionRepository.requestCall(requestInfo)>0;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean subscribe(String email) {
        try {
            return functionRepository.subscribe(email)>0;
        }catch (Exception e){
            return false;
        }
    }
}
