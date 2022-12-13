package com.example.bitcoinShopPractice.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Component
@Aspect
public class UserAop {

    @Pointcut("(execution(* com.example.bitcoinShopPractice.user.controller.UserController.*(..))" +
            "&& !@annotation(com.example.bitcoinShopPractice.aop.NoLogin))||" +
            "(execution(* com.example.bitcoinShopPractice.page.controller.PageController.*(..))" +
            "&& !@annotation(com.example.bitcoinShopPractice.aop.NoLogin))")
    public void cut(){}

    @Around("cut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        if(session.getAttribute("SESSION_INFO")==null){
            return "login";
        }else {
            return joinPoint.proceed();
        }
    }
}
