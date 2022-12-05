package com.example.bitcoinShopPractice.contact.service;

import com.example.bitcoinShopPractice.contact.repository.contactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class contactService {

    @Autowired
    contactRepository contactRepository;

    public boolean requestCall(HashMap<String,String> requestInfo){
        try{
            return contactRepository.requestCall(requestInfo)>0;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
