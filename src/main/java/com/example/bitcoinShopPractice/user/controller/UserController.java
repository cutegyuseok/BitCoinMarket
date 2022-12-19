package com.example.bitcoinShopPractice.user.controller;

import com.example.bitcoinShopPractice.aop.NoLogin;
import com.example.bitcoinShopPractice.user.DTO.PointInformationDTO;
import com.example.bitcoinShopPractice.user.DTO.UserDTO;
import com.example.bitcoinShopPractice.user.DTO.UserLoginDTO;
import com.example.bitcoinShopPractice.user.DTO.UserSignUpDTO;
import com.example.bitcoinShopPractice.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;

@Api(tags = {"사용자 서비스"},description = "사용자 관련 서비스")
@Controller
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    HttpSession session;

    @NoLogin
    @ApiOperation(value = "사용자 회원가입", notes = "사용자 회원가입 시도")
    @PostMapping("/signup")
    public String signup(UserSignUpDTO dto){
        if(userService.signup(dto)){
            return "login";
        }else return "signup";
    }

    @NoLogin
    @ApiOperation(value = "사용자 로그인", notes = "사용자 로그인 시도")
    @PostMapping("/login")
    public String login(UserLoginDTO dto){
        UserDTO userDTO = userService.login(dto);
        String url="index";
        if(session.getAttribute("SESSION_PRE_URL")!=null) {
            url = session.getAttribute("SESSION_PRE_URL").toString();
            url = "redirect:/" + url;
            session.setAttribute("SESSION_PRE_URL",null);
        }
        if(userDTO!=null){
        session.setAttribute("SESSION_INFO",userDTO);
        if (userDTO.getEmail().equals("yigyuseok@gmail.com")){
            session.setAttribute("SESSION_ACCESS","Y");
        }
        return url;
        }else {
            return "login";
        }
    }

    @ApiOperation(value = "사용자 금액 충전", notes = "사용자 거래용 금액 충전 시도")
    @GetMapping("/point")
    public String point(PointInformationDTO dto){
        UserDTO userDTO = (UserDTO)session.getAttribute("SESSION_INFO");
        if(userService.charge(dto,userDTO.getEmail())){
            System.out.println("charge success");
        }
        return "pay";
    }

    @NoLogin
    @ApiOperation(value = "사용자 로그아웃", notes = "사용자 로그아웃및 세션 삭제")
    @GetMapping("/logout")
    public String logout(){
        session.setAttribute("SESSION_INFO",null);
        session.setAttribute("ADMIN",null);
        session.setAttribute("SESSION_ACCESS",null);
        return "index";
    }

    @ApiOperation(value = "사용자 정보페이지", notes = "사용자 정보페이지 접근")
    @GetMapping("/goUserInfo")
    public String goUserInfo(@ApiIgnore Model model){
        UserDTO sessionUserDTO = (UserDTO)session.getAttribute("SESSION_INFO");
        double userMoney = userService.getUserPayment(sessionUserDTO.getEmail());
        model.addAttribute("userMoney",userMoney);
        return "userInfo";
    }


}
