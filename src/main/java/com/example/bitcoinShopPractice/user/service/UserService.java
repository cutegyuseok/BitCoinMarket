package com.example.bitcoinShopPractice.user.service;

import com.example.bitcoinShopPractice.user.DTO.*;
import com.example.bitcoinShopPractice.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean signup(UserSignUpDTO dto) {
        HashMap<String,String> map = new HashMap<>();
        map.put("email",dto.getEmail());
        map.put("name",dto.getName());
        map.put("password",dto.getPassword());
        map.put("phone",dto.getPhone());
        map.put("address",dto.getAddress());
        map.put("addressDetail",dto.getAddressDetail());
        try {
            return userRepository.signup(map)>0;

        }catch (Exception e){
            return false;
        }
    }

    public UserDTO login(UserLoginDTO dto){
        HashMap<String,String> map =new HashMap<>();
        map.put("email",dto.getEmail());
        map.put("password",dto.getPassword());
        try {
            HashMap<String,String> user = userRepository.login(map);
            return new UserDTO(user.get("email"),user.get("name"),user.get("phone"),user.get("address"),user.get("detail"));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean charge(PointInformationDTO dto, String email){
        HashMap<String,String> map = new HashMap<>();
        map.put("email",email);
        map.put("amount",dto.getAmount());
        map.put("uid",dto.getUid());
        try{
            return userRepository.charge(map)>0;
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

    public boolean buyCoin(BuyInformationDTO dto, String email){
        HashMap<String,String> map = new HashMap<>();
        map.put("email",email);
        map.put("price",dto.getPrice());
        map.put("id",dto.getId());
        map.put("name",dto.getName());
        map.put("answer",dto.getAnswer());
        map.put("amount",dto.getAmount());
        try{
            return userRepository.buyCoin(map)>0;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public double getBuyCoin(String email){
        return userRepository.getBuyCoin(email);
    }

    public ArrayList<HashMap<String,Object>> selectUserPointHistory(String email){
        return userRepository.selectUserPointHistory(email);
    }

    public ArrayList<HashMap<String,Object>> selectUserCoinHistory(String email){
        return userRepository.selectUserCoinHistory(email);
    }

}
