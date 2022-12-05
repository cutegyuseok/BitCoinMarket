package com.example.bitcoinShopPractice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value={"com.example.bitcoinShopPractice.mapper"})
public class BitCoinShopPracApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitCoinShopPracApplication.class, args);
    }

}
