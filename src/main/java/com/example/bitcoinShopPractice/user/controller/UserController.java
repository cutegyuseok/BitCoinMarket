package com.example.bitcoinShopPractice.user.controller;

import com.example.bitcoinShopPractice.user.DTO.UserDTO;
import com.example.bitcoinShopPractice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

@Controller
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    HttpSession session;
    @PostMapping("/signup")
    public String signup(@RequestParam HashMap<String,String> userInfo){
        if(userService.signup(userInfo)){
            return "login";
        }else return "signup";
    }

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

    @GetMapping("/logout")
    public String logout(){
        session.setAttribute("SESSION_INFO",null);
        return "index";
    }

    @GetMapping("/goUserInfo")
    public String goUserInfo(Model model){
        if(session.getAttribute("SESSION_INFO")==null)return "login";
        UserDTO sessionUserDTO = (UserDTO)session.getAttribute("SESSION_INFO");
        double userMoney = userService.getUserPayment(sessionUserDTO.getEmail());
        model.addAttribute("userMoney",userMoney);
        return "userInfo";
    }

    @GetMapping("/buyCoin")
    public @ResponseBody String  buyCoin(@RequestParam HashMap<String,String> buyInfo){
        if(session.getAttribute("SESSION_INFO")==null)return "login";
        UserDTO sessionUserDTO = (UserDTO)session.getAttribute("SESSION_INFO");
        if (userService.buyCoin(buyInfo,sessionUserDTO.getEmail())){
            System.out.println("buy success");
            return "success";
        }
        return "failed";
    }

    @GetMapping("/checkBalance")
    public @ResponseBody String checkBalance(@RequestParam String total){
        if(session.getAttribute("SESSION_INFO")==null)return "login";
        UserDTO userDTO = (UserDTO)session.getAttribute("SESSION_INFO");
        double doubleTotal = Double.valueOf(total);
        if(userService.getUserPayment(userDTO.getEmail())>=doubleTotal){
            return "can";
        }else return "cannot";
    }

    @GetMapping("/pointList")
    public @ResponseBody ArrayList<HashMap<String,Object>> pointList(){
        if(session.getAttribute("SESSION_INFO")==null)return null;
        UserDTO userDTO = (UserDTO)session.getAttribute("SESSION_INFO");
        return userService.selectUserPointHistory(userDTO.getEmail());
    }

    @GetMapping("/buyList")
    public @ResponseBody ArrayList<HashMap<String,Object>> buyList(){
        if(session.getAttribute("SESSION_INFO")==null)return null;
        UserDTO userDTO = (UserDTO)session.getAttribute("SESSION_INFO");
        return userService.selectUserCoinHistory(userDTO.getEmail());
    }

    @GetMapping("/goSell")
    public String goSell(){
        return "sell";
    }
}
