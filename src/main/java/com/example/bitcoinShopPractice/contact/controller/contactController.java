package com.example.bitcoinShopPractice.contact.controller;

import com.example.bitcoinShopPractice.contact.service.contactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class contactController {

    @Autowired
    contactService contactService;

    @PostMapping("/requestCall")
    public String requestCall(@RequestParam HashMap<String,String> requestInfo){
        if(contactService.requestCall(requestInfo)){
            //requestCall Success alert
            System.out.println("requestCall Success");
            return "index";
        }
        return "index";
    }
}
