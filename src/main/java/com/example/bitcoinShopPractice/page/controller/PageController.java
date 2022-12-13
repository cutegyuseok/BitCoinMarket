package com.example.bitcoinShopPractice.page.controller;

import com.example.bitcoinShopPractice.aop.NoLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class PageController {
    @Autowired
    HttpSession session;

    @NoLogin
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @NoLogin
    @GetMapping("/goSignup")
    public String goSignup(){
        if(session.getAttribute("SESSION_INFO")!=null)return "index";
        return "signup";
    }

    @NoLogin
    @GetMapping("/goLogin")
    public String goLogin(HttpServletRequest request){
        String referrer = request.getHeader("Referer").toString();
        if(!referrer.contains("goLogin")
                &&!referrer.contains("goSignup")){
            referrer = referrer.split("/")[referrer.split("/").length-1];
            if (!referrer.contains("localhost")) {
                session.setAttribute("SESSION_PRE_URL", referrer);
            }
        }
        if(session.getAttribute("SESSION_INFO")!=null)return "index";
        return "login";
    }

    @GetMapping("/goPay")
    public String goPay(){
        return "pay";
    }

    @GetMapping("/goHistory")
    public String goHistory(){
        return "history";
    }

    @NoLogin
    @GetMapping("/goMarket")
    public String goMarket(){
        return "market";
    }


}
