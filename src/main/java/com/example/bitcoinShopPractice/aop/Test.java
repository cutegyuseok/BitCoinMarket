//package com.example.bitcoinShopPractice.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.http.HttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpSession;
//
//@Aspect
//@Component
//public class Test {
//
//    @Pointcut("execution(* com.example.bitcoinShopPractice.page.controller.PageController.*(..))")
//    public void cut(){}
//
//    @After("cut()")
//    public void around(ProceedingJoinPoint joinPoint){
////        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
//        String str = joinPoint.getSignature().getName().toString();
//        System.out.println(str);
//
//    }
//}
