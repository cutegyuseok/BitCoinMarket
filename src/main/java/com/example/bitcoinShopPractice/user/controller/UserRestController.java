package com.example.bitcoinShopPractice.user.controller;

import com.example.bitcoinShopPractice.aop.NoLogin;
import com.example.bitcoinShopPractice.user.DTO.UserDTO;
import com.example.bitcoinShopPractice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class UserRestController {

    @Autowired
    UserService userService;

    @Autowired
    HttpSession session;

    @NoLogin
    @GetMapping("/buyCoin")
    public String  buyCoin(@RequestParam HashMap<String,String> buyInfo){
        UserDTO sessionUserDTO = (UserDTO)session.getAttribute("SESSION_INFO");
        if (userService.buyCoin(buyInfo,sessionUserDTO.getEmail())){
            return "success";
        }
        return "failed";
    }

    @NoLogin //login 으로 return 하는 예외
    @GetMapping("/checkBalance")
    public String checkBalance(@RequestParam String total){
        if(session.getAttribute("SESSION_INFO")==null)return "login";
        UserDTO userDTO = (UserDTO)session.getAttribute("SESSION_INFO");
        double doubleTotal = Double.valueOf(total);
        if(userService.getUserPayment(userDTO.getEmail())>=doubleTotal){
            return "can";
        }else return "cannot";
    }

    @GetMapping("/pointList")
    public ArrayList<HashMap<String,Object>> pointList(){
        UserDTO userDTO = (UserDTO)session.getAttribute("SESSION_INFO");
        return userService.selectUserPointHistory(userDTO.getEmail());
    }

    @GetMapping("/buyList")
    public ArrayList<HashMap<String,Object>> buyList(){
        UserDTO userDTO = (UserDTO)session.getAttribute("SESSION_INFO");
        return userService.selectUserCoinHistory(userDTO.getEmail());
    }
}
