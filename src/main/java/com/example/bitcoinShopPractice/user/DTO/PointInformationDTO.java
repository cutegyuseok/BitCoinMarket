package com.example.bitcoinShopPractice.user.DTO;

public class PointInformationDTO {
    private String amount;
    private String uid;

    public PointInformationDTO(String amount, String uid) {
        this.amount = amount;
        this.uid = uid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
