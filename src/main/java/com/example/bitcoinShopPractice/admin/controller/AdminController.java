package com.example.bitcoinShopPractice.admin.controller;

import com.example.bitcoinShopPractice.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class AdminController {

    @Autowired
    HttpSession session;

    @Autowired
    AdminService adminService;

    @PostMapping("/adminLogin")
    public String adminLogin(@RequestParam HashMap<String,String> loginInfo){
        if(adminService.adminLogin(loginInfo)!=null){
            session.setAttribute("ADMIN",adminService.adminLogin(loginInfo));
            return "adminIndex";
        }
        return "adminLogin";
    }
}
