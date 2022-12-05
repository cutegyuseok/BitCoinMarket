package com.example.bitcoinShopPractice.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface userMapper {

    public int signup(HashMap<String,String> userInfo);

    public HashMap<String,String> login(HashMap<String,String> userInfo);

    public int charge(HashMap<String,String> chargeInfo);

}
