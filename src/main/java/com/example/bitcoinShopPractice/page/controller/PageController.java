package com.example.bitcoinShopPractice.page.controller;

import com.example.bitcoinShopPractice.aop.NoLogin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Api(tags = {"거래소 페이지 서비스"},description = "비트코인 거래소 관련 서비스")
@Controller
public class PageController {
    @Autowired
    HttpSession session;

    @NoLogin
    @ApiOperation(value = "메인 페이지", notes = "메인 페이지 접근")
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @NoLogin
    @ApiOperation(value = "회원가입 페이지", notes = "회원가입 페이지 접근")
    @GetMapping("/goSignup")
    public String goSignup(){
        if(session.getAttribute("SESSION_INFO")!=null)return "index";
        return "signup";
    }

    @ApiOperation(value = "로그인 페이지", notes = "로그인 페이지 접근")
    @NoLogin
    @GetMapping("/goLogin")
    public String goLogin(@ApiIgnore HttpServletRequest request){
        String referrer = request.getHeader("Referer").toString();
        if(!referrer.contains("goLogin")
                &&!referrer.contains("goSignup")){
            referrer = referrer.split("/")[referrer.split("/").length-1];
            if (!referrer.contains("localhost")) {
                session.setAttribute("SESSION_PRE_URL", referrer);
            }
        }
        if(session.getAttribute("SESSION_INFO")!=null)return "index";
        return "login";
    }

    @ApiOperation(value = "충전 페이지", notes = "포인트 충전 페이지 접근")
    @GetMapping("/goPay")
    public String goPay(){
        return "pay";
    }

    @ApiOperation(value = "거래 기록 페이지", notes = "사용자 거래 기록 조회 페이지 접근")
    @GetMapping("/goHistory")
    public String goHistory(){
        return "history";
    }

    @NoLogin
    @ApiOperation(value = "코인 거래 페이지 접근", notes = "거래가능 코인 목록및 거래 페이지 접근")
    @GetMapping("/goMarket")
    public String goMarket(){
        return "market";
    }


}
