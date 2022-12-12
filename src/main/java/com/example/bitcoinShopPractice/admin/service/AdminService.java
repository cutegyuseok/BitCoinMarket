package com.example.bitcoinShopPractice.admin.service;

import com.example.bitcoinShopPractice.admin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public String adminLogin(HashMap<String,String> loginInfo){
        return adminRepository.adminLogin(loginInfo);
    }

    public int cntMember(){
        return adminRepository.cntMember();
    }

    public double amountPayment(){
        return adminRepository.amountPayment();
    }

    public int selectCntBuy(){
        return adminRepository.selectCntBuy();
    }

    public int selectCntContact(){
        return adminRepository.selectCntContact();
    }

    public ArrayList<HashMap<String,Object>> selectMember(){
        return adminRepository.selectMember();
    }

    public ArrayList<HashMap<String,Object>> selectPayment(){
        return adminRepository.selectPayment();
    }

    public ArrayList<HashMap<String,Object>> selectBuy(){
        return adminRepository.selectBuy();
    }
}
