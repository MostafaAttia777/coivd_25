package com.MostafaCovied.Mostafacovied.Models;

public class Model_Regastar {

    private String name;
    private String email;
    private String phone;
    private String address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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


    public Model_Regastar(String name, String emai, String phone, String address) {
        this.name = name;
        this.email = emai;
        this.phone = phone;
        this.address = address;

    }
}
