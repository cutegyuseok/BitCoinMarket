package com.example.bitcoinShopPractice.user.controller;

import com.example.bitcoinShopPractice.user.DTO.userDTO;
import com.example.bitcoinShopPractice.user.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class userController {


    @Autowired
    userService userService;

    @PostMapping("/signup")
    public String signup(@RequestParam HashMap<String,String> userInfo){
        if(userService.signup(userInfo)>0){
            return "index";
        }else return "signup";
    }

    @PostMapping("/login")
    public String login(@RequestParam HashMap<String,String> userInfo, HttpSession session){
        userDTO userDTO = userService.login(userInfo);
        if(userDTO!=null){
        session.setAttribute("SESSION_INFO",userDTO);
        return "index";
        }else {
            return "login";
        }
    }

    @GetMapping("/point")
    public String point(@RequestParam HashMap<String,String> pointInfo){
        System.out.println(pointInfo.toString());
        return "pay";
    }

}
