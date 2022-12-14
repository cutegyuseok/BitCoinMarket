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
public class AopExample {
    @Pointcut("execution(* com.example.bitcoinShopPractice.page.controller.AdminPageController.*(..))" + //디렉토리
            "&& !@annotation(com.example.bitcoinShopPractice.aop.NoLogin)") //제외하고싶은 메서드
    public void cut(){}

    @Around("cut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
//        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
//        if(session.getAttribute("ADMIN")==null){
//            return "index";
//        }else {
//            return joinPoint.proceed();
//        }예시

        System.out.println("AOP 작동");
    }
}
