package com.example.bitcoinShopPractice.nonLoginFunction.controller;

import com.example.bitcoinShopPractice.nonLoginFunction.service.FunctionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Api(tags = {"비로그인 사용가능 기능"},description = "비로그인 사용가능 서비스")
@Controller
public class FunctionController {

    @Autowired
    FunctionService functionService;

    @ApiOperation(value = "연락 요청", notes = "연락 요청 시도")
    @PostMapping("/requestCall")
    public String requestCall(@RequestParam HashMap<String,String> requestInfo){
        if(functionService.requestCall(requestInfo)){
            System.out.println("requestCall Success");
        }
        return "index";
    }

    @ApiOperation(value = "구독 요청", notes = "구독 요청 시도")
    @GetMapping("/subscribe")
    public String subscribe(@RequestParam HashMap<String,String> subscribe){
       String email = subscribe.get("email");
       String url = subscribe.get("url");
        if(functionService.subscribe(email)){
            System.out.println("subscribe Success");
        }
        return url;
    }

}
