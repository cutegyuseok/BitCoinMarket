package com.example.bitcoinShopPractice.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface FunctionMapper {

    public int requestCall(HashMap<String,String> requestInfo);

    public int subscribe(String email);
}
