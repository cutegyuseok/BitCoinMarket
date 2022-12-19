package com.example.bitcoinShopPractice.user.DTO;

public class BuyInformationDTO {
    private String price;
    private String id;
    private String name;
    private String answer;
    private String amount;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public BuyInformationDTO(String price, String id, String name, String answer, String amount) {
        this.price = price;
        this.id = id;
        this.name = name;
        this.answer = answer;
        this.amount = amount;
    }
}
