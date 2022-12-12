package com.example.bitcoinShopPractice.admin.repository;

import com.example.bitcoinShopPractice.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class AdminRepository {

    @Autowired
    AdminMapper adminMapper;

    public String adminLogin(HashMap<String,String> loginInfo){
        return adminMapper.adminLogin(loginInfo);
    }

    public int cntMember(){
        return adminMapper.cntMember();
    }

    public double amountPayment(){
        return adminMapper.amountPayment();
    }

    public int selectCntBuy(){
        return adminMapper.selectCntBuy();
    }

    public int selectCntContact(){
        return adminMapper.selectCntContact();
    }

    public ArrayList<HashMap<String,Object>> selectMember(){
        return adminMapper.selectMember();
    }

    public ArrayList<HashMap<String,Object>> selectPayment(){
        return adminMapper.selectPayment();
    }
}
