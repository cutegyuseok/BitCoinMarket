package com.example.bitcoinShopPractice.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface AdminMapper {

    public String adminLogin(HashMap<String,String> loginInfo);

    public int cntMember();

    public double amountPayment();

    public int selectCntBuy();

    public int selectCntContact();

    public ArrayList<HashMap<String,Object>> selectMember();
    public ArrayList<HashMap<String,Object>> selectPayment();

    public ArrayList<HashMap<String,Object>> selectBuy();


}
