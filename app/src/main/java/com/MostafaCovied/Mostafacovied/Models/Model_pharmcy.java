package com.MostafaCovied.Mostafacovied.Models;

public class Model_pharmcy {

    private String name_ph;
    private String address_ph;
    private String phone_ph;
    private String phone_ph_wh;


    public String getPhone_ph_wh() {
        return phone_ph_wh;
    }

    public void setPhone_ph_wh(String phone_ph_wh) {
        this.phone_ph_wh = phone_ph_wh;
    }


    public Model_pharmcy(String name_ph, String address_ph, String phone_ph, String phone_ph_wh) {
        this.name_ph = name_ph;
        this.address_ph = address_ph;
        this.phone_ph = phone_ph;
        this.phone_ph_wh = phone_ph_wh;
    }

    public Model_pharmcy() {
    }

    public String getName_ph() {
        return name_ph;
    }

    public void setName_ph(String name_ph) {
        this.name_ph = name_ph;
    }

    public String getAddress_ph() {
        return address_ph;
    }

    public void setAddress_ph(String address_ph) {
        this.address_ph = address_ph;
    }

    public String getPhone_ph() {
        return phone_ph;
    }

    public void setPhone_ph(String phone_ph) {
        this.phone_ph = phone_ph;
    }

    @Override
    public String toString() {
        return "Model_pharmcy{" +
                "name_ph='" + name_ph + '\'' +
                ", address_ph='" + address_ph + '\'' +
                ", phone_ph='" + phone_ph + '\'' +
                ", phone_ph_wh='" + phone_ph_wh + '\'' +
                '}';
    }
}
