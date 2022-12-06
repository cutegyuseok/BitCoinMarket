package com.example.bitcoinShopPractice.user.DTO;

public class UserDTO {
    private String email;
    private String name;
    private String phone;
    private String address;
    private String detail;
    private int money;


    public UserDTO(String email, String name, String phone, String address, String detail) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.detail = detail;
    }

    public UserDTO(String email, String name, String phone, String address, String detail, int money) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.detail = detail;
        this.money = money;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "userDTO{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", detail='" + detail + '\'' +
                ", money=" + money +
                '}';
    }
}
