package com.example.bitcoinShopPractice.admin.service;

import com.example.bitcoinShopPractice.admin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public String adminLogin(HashMap<String,String> loginInfo){
        return adminRepository.adminLogin(loginInfo);
    }

    public HashMap<String,String> cntMember(){
        return adminRepository.cntMember();
    }
}
