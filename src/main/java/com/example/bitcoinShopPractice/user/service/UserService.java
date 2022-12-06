package com.example.bitcoinShopPractice.user.service;

import com.example.bitcoinShopPractice.user.DTO.UserDTO;
import com.example.bitcoinShopPractice.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public int signup(HashMap<String, String> userInfo) {

        try {
            userRepository.signup(userInfo);
            return 1;
        }catch (Exception e){
            return -1;
        }
    }

    public UserDTO login(HashMap<String,String> userInfo){
        try {
            HashMap<String,String> user = userRepository.login(userInfo);
            return new UserDTO(user.get("email"),user.get("name"),user.get("phone"),user.get("address"),user.get("detail"));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean charge(HashMap<String,String> chargeInfo,String email){
        chargeInfo.put("email",email);
        try{
            return userRepository.charge(chargeInfo)>0;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public double getUserPayment(String email){
        double userMoney = 0;
        try {
            userMoney += userRepository.getUserPayment(email);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            userMoney -= getBuyCoin(email);
        }catch (Exception e){
            e.printStackTrace();
        }
        //판매금액 += ;
        return userMoney;
    }

    public boolean buyCoin(HashMap<String,String> buyInfo,String email){
        buyInfo.put("email",email);
        double price =Double.valueOf(buyInfo.get("price"));
        double answer =Double.valueOf(buyInfo.get("answer"));
        double amount =(answer*price);
        String result = String.valueOf(amount);
        buyInfo.put("amount",result);
        if(getUserPayment(email)<amount){
            return false;
        }
        try{
            return userRepository.buyCoin(buyInfo)>0;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public double getBuyCoin(String email){
        return userRepository.getBuyCoin(email);
    }

}
