package com.example.bitcoinshopprac.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class pageController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("goSignup")
    public String goSignup(HttpSession session){
        if(session.getAttribute("SESSION_ID")!=null)return "index";
        return "signup";
    }
}
