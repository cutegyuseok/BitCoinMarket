package com.example.bitcoinShopPractice.nonLoginFunction.controller;

import com.example.bitcoinShopPractice.nonLoginFunction.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class FunctionController {

    @Autowired
    FunctionService functionService;

    @PostMapping("/requestCall")
    public String requestCall(@RequestParam HashMap<String,String> requestInfo){
        if(functionService.requestCall(requestInfo)){
            //requestCall Success alert
            System.out.println("requestCall Success");
        }
        return "index";
    }

    @GetMapping("/subscribe")
    public String subscribe(@RequestParam HashMap<String,String> subscribe){
       String email = subscribe.get("email");
       String url = subscribe.get("url");
        if(functionService.subscribe(email)){
            System.out.println("subscribe Success");
        }
        return url;
    }

}
