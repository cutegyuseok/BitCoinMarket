package com.example.bitcoinShopPractice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value={"com.example.bitcoinShopPractice.mapper"})
public class BitcoinShopPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitcoinShopPracticeApplication.class, args);
    }

}
