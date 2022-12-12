package com.example.bitcoinShopPractice.admin.repository;

import com.example.bitcoinShopPractice.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class AdminRepository {

    @Autowired
    AdminMapper adminMapper;

    public String adminLogin(HashMap<String,String> loginInfo){
        return adminMapper.adminLogin(loginInfo);
    }

    public HashMap<String,String> cntMember(){
        return adminMapper.cntMember();
    }
}
