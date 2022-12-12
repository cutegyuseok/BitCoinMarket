package com.example.bitcoinShopPractice.admin.controller;

import com.example.bitcoinShopPractice.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class AdminRestController {

    @Autowired
    AdminService adminService;

    @GetMapping("/selectCntMember")
    public String cntMember(){
        System.out.println("응애");
        System.out.println(adminService.cntMember().toString());
        return adminService.cntMember().toString();
    }

}
