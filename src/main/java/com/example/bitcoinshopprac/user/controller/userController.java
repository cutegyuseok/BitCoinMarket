package com.example.bitcoinshopprac.user.controller;

import com.example.bitcoinshopprac.user.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        String userEmail = userService.login(userInfo);
        if(userEmail.equals(userInfo.get("email").toString())){
        session.setAttribute("SESSION_ID",userEmail);
        return "index";
        }else {
            return "login";
        }
    }

}
