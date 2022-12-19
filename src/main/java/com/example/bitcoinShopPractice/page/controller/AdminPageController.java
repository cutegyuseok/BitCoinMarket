package com.example.bitcoinShopPractice.page.controller;

import com.example.bitcoinShopPractice.aop.NoLogin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Api(tags = {"관리자 페이지 서비스"},description = "관리자 관련 서비스")
@Controller
public class AdminPageController {

    @Autowired
    HttpSession session;

    @NoLogin
    @ApiOperation(value = "관리자 페이지 접근", notes = "관리자 로그인 페이지 접근 시도")
    @GetMapping("/goAdminPage")
    public String goAdminPage(){
        if(session.getAttribute("SESSION_ACCESS")==null)return "index";
        if(session.getAttribute("ADMIN")!=null)return "adminIndex";
        return "adminLogin";
    }

    @ApiOperation(value = "회원 목록 페이지", notes = "회원 목록 페이지 접근")
    @GetMapping("/goMember")
    public String goMember(){
        return "memberList";
    }

    @ApiOperation(value = "결재 목록 페이지", notes = "결재 목록 페이지 접근")
    @GetMapping("/goPayment")
    public String goPayment(){
        return "paymentList";
    }

    @ApiOperation(value = "구매 목록 페이지", notes = "구매 목록 페이지 접근")
    @GetMapping("/goBuy")
    public String goBuy(){
        return "buyList";
    }

    @ApiOperation(value = "연락 요청 목록 페이지", notes = "연락 요청 목록 페이지 접근")
    @GetMapping("/goContact")
    public String goContact(){
        return "contactList";
    }

    @ApiOperation(value = "구독 목록 페이지", notes = "구독 목록 페이지 접근")
    @GetMapping("goSubscribe")
    public String goSubscribe(){
        return "subscribeList";
    }
}
