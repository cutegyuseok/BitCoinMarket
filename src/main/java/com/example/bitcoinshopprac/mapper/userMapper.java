package com.example.bitcoinshopprac.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface userMapper {

    public int signup(HashMap<String,String> userInfo);

    public String login(HashMap<String,String> userInfo);

}
