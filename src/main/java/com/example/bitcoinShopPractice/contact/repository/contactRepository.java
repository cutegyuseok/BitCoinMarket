package com.example.bitcoinShopPractice.contact.repository;

import com.example.bitcoinShopPractice.mapper.contactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class contactRepository {

    @Autowired
    contactMapper contactMapper;

    public int requestCall(HashMap<String,String> requestInfo){
        return contactMapper.requestCall(requestInfo);
    }
}
