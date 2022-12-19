package com.example.bitcoinShopPractice.admin.controller;

import com.example.bitcoinShopPractice.admin.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@Api(tags = {"관리자 서비스"},description = "관리자 관련 서비스")
@RestController
public class AdminRestController {

    @Autowired
    AdminService adminService;

    @ApiOperation(value = "총 회원 수", notes = "총 가입된 회원수를 조회한다")
    @GetMapping("/selectCntMember")
    public int cntMember(){
        return adminService.cntMember();
    }

    @ApiOperation(value = "총 포인트 판매량", notes = "총 포인트 판매량을 조회한다")
    @GetMapping("/selectAmountPayment")
    public double selectAmountPayment(){
        return adminService.amountPayment();
    }

    @ApiOperation(value = "총 코인 거래 횟수", notes = "총 코인 거래량을 조회한다")
    @GetMapping("/selectCntBuy")
    public int selectCntBuy(){
        return adminService.selectCntBuy();
    }

    @ApiOperation(value = "총 연락 요청 횟수", notes = "총 연락 요청 횟수를 조회한다")
    @GetMapping("/selectCntContact")
    public int selectCntContact(){
        return adminService.selectCntContact();
    }

    @ApiOperation(value = "회원 조회", notes = "모든 회원의 정보를 조회한다.")
    @GetMapping("/selectMember")
    public ArrayList<HashMap<String,Object>> selectMember(){
        return adminService.selectMember();
    }

    @ApiOperation(value = "충전 기록 조회", notes = "모든 충전 기록을 조회한다")
    @GetMapping("/selectPayment")
    public ArrayList<HashMap<String,Object>> selectPayment(){
        return adminService.selectPayment();
    }

    @ApiOperation(value = "코인 거래 기록 조회", notes = "모든 코인 거래 기록을 조회한다")
    @GetMapping("/selectBuy")
    public ArrayList<HashMap<String,Object>> selectBuy(){
        return adminService.selectBuy();
    }


    @ApiOperation(value = "구독 목록 조회", notes = "모든 구독 목록을 조회한다")
    @GetMapping("/selectSubscribe")
    public ArrayList<HashMap<String,Object>> selectSubscribe(){
        return adminService.selectSubscribe();
    }

    @ApiOperation(value = "모든 연락 요청 기록 조회", notes = "모든 연락 요청 기록을 조회한다")
    @GetMapping("/selectContact")
    public ArrayList<HashMap<String,Object>> selectContact(){
        return adminService.selectContact();
    }


}
