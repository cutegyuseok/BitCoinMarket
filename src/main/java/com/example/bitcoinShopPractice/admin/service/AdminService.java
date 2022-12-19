package com.example.bitcoinShopPractice.admin.service;

import com.example.bitcoinShopPractice.admin.dto.AdminDTO;
import com.example.bitcoinShopPractice.admin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public String adminLogin(AdminDTO dto){
        HashMap<String,String> map = new HashMap<>();
        map.put("id",dto.getId());
        map.put("password",dto.getPassword());
        return adminRepository.adminLogin(map);
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

    public ArrayList<HashMap<String,Object>> selectSubscribe(){
        return adminRepository.selectSubscribe();
    }
    public ArrayList<HashMap<String,Object>> selectContact(){
        return adminRepository.selectContact();
    }
}
