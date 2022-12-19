package com.example.bitcoinShopPractice.user.controller;

import com.example.bitcoinShopPractice.aop.NoLogin;
import com.example.bitcoinShopPractice.user.DTO.BuyInformationDTO;
import com.example.bitcoinShopPractice.user.DTO.UserDTO;
import com.example.bitcoinShopPractice.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

@Api(tags = {"사용자 거래 서비스"},description = "사용자 거래 관련 서비스")
@RestController
public class UserRestController {

    @Autowired
    UserService userService;

    @Autowired
    HttpSession session;

    @NoLogin
    @ApiOperation(value = "사용자 코인 구매", notes = "사용자 비트코인 구매 시도")
    @PostMapping("/buyCoin")
    public String  buyCoin(BuyInformationDTO dto){
        UserDTO sessionUserDTO = (UserDTO)session.getAttribute("SESSION_INFO");
        if (userService.buyCoin(dto,sessionUserDTO.getEmail())){
            return "success";
        }
        return "failed";
    }

    @NoLogin
    @ApiOperation(value = "거래 가능 상태 확인", notes = "거래 시도시 거래 가능 상태 확인. login 으로 return 하는 예외 존재")
    @GetMapping("/checkBalance")
    public String checkBalance(@RequestParam String total){
        if(session.getAttribute("SESSION_INFO")==null)return "login";
        UserDTO userDTO = (UserDTO)session.getAttribute("SESSION_INFO");
        double doubleTotal = Double.valueOf(total);
        if(userService.getUserPayment(userDTO.getEmail())>=doubleTotal){
            return "can";
        }else return "cannot";
    }

    @ApiOperation(value = "사용자 충전 기록 조회", notes = "사용자 사용가능 충전 기록 조회")
    @GetMapping("/pointList")
    public ArrayList<HashMap<String,Object>> pointList(){
        UserDTO userDTO = (UserDTO)session.getAttribute("SESSION_INFO");
        return userService.selectUserPointHistory(userDTO.getEmail());
    }

    @ApiOperation(value = "사용자 코인 거래 기록 조회", notes = "사용자 코인 거래 내역 리스트 조회")
    @GetMapping("/buyList")
    public ArrayList<HashMap<String,Object>> buyList(){
        UserDTO userDTO = (UserDTO)session.getAttribute("SESSION_INFO");
        return userService.selectUserCoinHistory(userDTO.getEmail());
    }
}
