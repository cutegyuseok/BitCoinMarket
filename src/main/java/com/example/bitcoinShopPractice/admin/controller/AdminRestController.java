package com.example.bitcoinShopPractice.admin.controller;

import com.example.bitcoinShopPractice.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class AdminRestController {

    @Autowired
    AdminService adminService;

    @GetMapping("/selectCntMember")
    public int cntMember(){
        return adminService.cntMember();
    }

    @GetMapping("/selectAmountPayment")
    public double selectAmountPayment(){
        return adminService.amountPayment();
    }

    @GetMapping("/selectCntBuy")
    public int selectCntBuy(){
        return adminService.selectCntBuy();
    }

    @GetMapping("/selectCntContact")
    public int selectCntContact(){
        return adminService.selectCntContact();
    }
    @GetMapping("/selectMember")
    public ArrayList<HashMap<String,Object>> selectMember(){
        return adminService.selectMember();
    }

    @GetMapping("/selectPayment")
    public ArrayList<HashMap<String,Object>> selectPayment(){
        return adminService.selectPayment();
    }

    @GetMapping("/selectBuy")
    public ArrayList<HashMap<String,Object>> selectBuy(){
        return adminService.selectBuy();
    }


    @GetMapping("/selectSubscribe")
    public ArrayList<HashMap<String,Object>> selectSubscribe(){
        return adminService.selectSubscribe();
    }

    @GetMapping("/selectContact")
    public ArrayList<HashMap<String,Object>> selectContact(){
        return adminService.selectContact();
    }


}
