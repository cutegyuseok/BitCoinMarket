package com.example.bitcoinShopPractice.nonLoginFunction.controller;

import com.example.bitcoinShopPractice.nonLoginFunction.service.functionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class functionController {

    @Autowired
    functionService functionService;

    @PostMapping("/requestCall")
    public String requestCall(@RequestParam HashMap<String,String> requestInfo){
        if(functionService.requestCall(requestInfo)){
            //requestCall Success alert
            System.out.println("requestCall Success");
        }
        return "index";
    }

    @GetMapping("/subscribe")
    public String subscribe(@RequestParam String email){
        if(functionService.subscribe(email)){
            //subscribe Success alert
            System.out.println("subscribe Success");
        }
        return "index";
    }

}
