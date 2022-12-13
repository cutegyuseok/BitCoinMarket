package com.example.bitcoinShopPractice.page.controller;

import com.example.bitcoinShopPractice.aop.NoLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminPageController {

    @Autowired
    HttpSession session;

    @NoLogin
    @GetMapping("/goAdminPage")
    public String goAdminPage(){
        if(session.getAttribute("SESSION_ACCESS")==null)return "index";
        if(session.getAttribute("ADMIN")!=null)return "adminIndex";
        return "adminLogin";
    }

    @GetMapping("/goMember")
    public String goMember(){
        return "memberList";
    }

    @GetMapping("/goPayment")
    public String goPayment(){
        return "paymentList";
    }

    @GetMapping("/goBuy")
    public String goBuy(){
        return "buyList";
    }

    @GetMapping("/goContact")
    public String goContact(){
        return "contactList";
    }

    @GetMapping("goSubscribe")
    public String goSubscribe(){
        return "subscribeList";
    }
}
