package com.MostafaCovied.Mostafacovied.Models;

public class Lab_Model {


    private  String name_ph_lab;
    private  String address_ph_lab;
    private  String phone_ph_lab;

    public Lab_Model(String name_ph_lab, String address_ph_lab, String phone_ph_lab, String phone_ph_wh_lab) {
        this.name_ph_lab = name_ph_lab;
        this.address_ph_lab = address_ph_lab;
        this.phone_ph_lab = phone_ph_lab;
        this.phone_ph_wh_lab = phone_ph_wh_lab;
    }

    public String getName_ph_lab() {
        return name_ph_lab;
    }

    public void setName_ph_lab(String name_ph_lab) {
        this.name_ph_lab = name_ph_lab;
    }

    public String getAddress_ph_lab() {
        return address_ph_lab;
    }

    public void setAddress_ph_lab(String address_ph_lab) {
        this.address_ph_lab = address_ph_lab;
    }

    public String getPhone_ph_lab() {
        return phone_ph_lab;
    }

    public void setPhone_ph_lab(String phone_ph_lab) {
        this.phone_ph_lab = phone_ph_lab;
    }

    public String getPhone_ph_wh_lab() {
        return phone_ph_wh_lab;
    }

    public void setPhone_ph_wh_lab(String phone_ph_wh_lab) {
        this.phone_ph_wh_lab = phone_ph_wh_lab;
    }

    private  String phone_ph_wh_lab;

}
