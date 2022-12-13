package com.example.bitcoinShopPractice.page.controller;

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

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/goSignup")
    public String goSignup(){
        if(checkLoginStatus())return "index";
        return "signup";
    }
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
        if (checkLoginStatus())return "index";
        return "login";
    }

    @GetMapping("/goPay")
    public String goPay(){
        if(!checkLoginStatus())return "login";
        return "pay";
    }

    @GetMapping("/goHistory")
    public String goHistory(){
        if(!checkLoginStatus())return "login";
        return "history";
    }

    @GetMapping("/goMarket")
    public String goMarket(){
        return "market";
    }

    @GetMapping("/goAdminPage")
    public String goAdminPage(){
        if(session.getAttribute("SESSION_ACCESS")==null)return "index";
        if(checkAdminStatus())return "adminIndex";
        return "adminLogin";
    }

    @GetMapping("/goMember")
    public String goMember(){
        if(!checkAdminStatus())return "index";
        return "memberList";
    }

    @GetMapping("/goPayment")
    public String goPayment(){
        if(!checkAdminStatus())return "index";
        return "paymentList";
    }

    @GetMapping("/goBuy")
    public String goBuy(){
        if(!checkAdminStatus())return "index";
        return "buyList";
    }

    @GetMapping("/goContact")
    public String goContact(){
        if(!checkAdminStatus())return "index";
        return "contactList";
    }

    @GetMapping("goSubscribe")
    public String goSubscribe(){
        if(!checkAdminStatus())return "index";
        return "subscribeList";
    }




    public  boolean checkLoginStatus( ){
        if(session.getAttribute("SESSION_INFO")!=null){
            return true;
        }else return false;
    }

    public boolean checkAdminStatus(){
        if (session.getAttribute("ADMIN")==null){
            return false;
        }else {
            return true;
        }
    }

}
