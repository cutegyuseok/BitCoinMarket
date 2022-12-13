package com.example.bitcoinShopPractice.user.controller;

import com.example.bitcoinShopPractice.aop.NoLogin;
import com.example.bitcoinShopPractice.user.DTO.UserDTO;
import com.example.bitcoinShopPractice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    HttpSession session;

    @NoLogin
    @PostMapping("/signup")
    public String signup(@RequestParam HashMap<String,String> userInfo){
        if(userService.signup(userInfo)){
            return "login";
        }else return "signup";
    }

    @NoLogin
    @PostMapping("/login")
    public String login(@RequestParam HashMap<String,String> userInfo){
        UserDTO userDTO = userService.login(userInfo);
        String url="index";
        if(session.getAttribute("SESSION_PRE_URL")!=null) {
            url = session.getAttribute("SESSION_PRE_URL").toString();
            url = "redirect:/" + url;
            session.setAttribute("SESSION_PRE_URL",null);
        }
        if(userDTO!=null){
        session.setAttribute("SESSION_INFO",userDTO);
        if (userDTO.getEmail().equals("yigyuseok@gmail.com")){
            session.setAttribute("SESSION_ACCESS","Y");
        }
        return url;
        }else {
            return "login";
        }
    }

    @GetMapping("/point")
    public String point(@RequestParam HashMap<String,String> pointInfo){
        UserDTO userDTO = (UserDTO)session.getAttribute("SESSION_INFO");
        if(userService.charge(pointInfo,userDTO.getEmail())){
            System.out.println("charge success");
        }
        return "pay";
    }

    @NoLogin
    @GetMapping("/logout")
    public String logout(){
        session.setAttribute("SESSION_INFO",null);
        session.setAttribute("ADMIN",null);
        session.setAttribute("SESSION_ACCESS",null);
        return "index";
    }

    @GetMapping("/goUserInfo")
    public String goUserInfo(Model model){
        UserDTO sessionUserDTO = (UserDTO)session.getAttribute("SESSION_INFO");
        double userMoney = userService.getUserPayment(sessionUserDTO.getEmail());
        model.addAttribute("userMoney",userMoney);
        return "userInfo";
    }


}
