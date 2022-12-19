package com.example.bitcoinShopPractice.admin.controller;

import com.example.bitcoinShopPractice.admin.dto.AdminDTO;
import com.example.bitcoinShopPractice.admin.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Api(tags = {"관리자 페이지 서비스"},description = "관리자 관련 서비스")
@Controller
public class AdminController {

    @Autowired
    HttpSession session;

    @Autowired
    AdminService adminService;

    @ApiOperation(value = "관리자 로그인", notes = "관리자 권한 로그인 시도")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "관리자 식별 ID", required = true),
            @ApiImplicitParam(name = "password", value = "관리자 비밀번호", required = true)
    })
    @PostMapping("/adminLogin") // api에서 제외하고싶으면 @ApiIgnore
    public String adminLogin(AdminDTO dto){
        if(adminService.adminLogin(dto)!=null){
            session.setAttribute("ADMIN",adminService.adminLogin(dto));
            return "adminIndex";
        }
        return "adminLogin";
    }
}
