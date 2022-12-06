package com.example.bitcoinShopPractice.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface UserMapper {

    public int signup(HashMap<String,String> userInfo);

    public HashMap<String,String> login(HashMap<String,String> userInfo);

    public int charge(HashMap<String,String> chargeInfo);

    public long getUserPayment(String email);

    public int buyCoin(HashMap<String,String> buyInfo);

    public double getBuyCoin(String email);

    public ArrayList<HashMap<String,String>> getUserCoinInfo(String email);

}
