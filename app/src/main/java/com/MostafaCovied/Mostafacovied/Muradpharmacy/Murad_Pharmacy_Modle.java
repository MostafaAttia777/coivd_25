package com.MostafaCovied.Mostafacovied.Muradpharmacy;

public class Murad_Pharmacy_Modle {
    private String med_name;
    private int med_price;
    private int count;
    private int mult;
    private String med_image;
    String user_id;
    private String order_id;
    String customer_address;
    String customer_name;
    String customer_sign;
    String total_price;

    public int getMult() {
        return mult;
    }

    public void setMult(int mult) {
        this.mult = mult;
    }


    public Murad_Pharmacy_Modle(String med_name, int mult, int count, String med_image) {
        this.med_name = med_name;
        this.mult = mult;
        this.count = count;
        this.med_image = med_image;

    }



    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getMed_name() {
        return med_name;
    }

    public void setMed_name(String med_name) {
        this.med_name = med_name;
    }

    public int getMed_price() {
        return med_price;
    }

    public void setMed_price(int med_price) {
        this.med_price = med_price;
    }

    public String getMed_image() {
        return med_image;
    }

    public void setMed_image(String med_image) {
        this.med_image = med_image;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_sign() {
        return customer_sign;
    }

    public Murad_Pharmacy_Modle() {
    }

    public void setCustomer_sign(String customer_sign) {
        this.customer_sign = customer_sign;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    String customer_phone;

    public Murad_Pharmacy_Modle(String customer_address, String customer_name, String customer_sign, String customer_phone,String user_id,String total_price) {
        this.customer_address = customer_address;
        this.customer_name = customer_name;
        this.customer_sign = customer_sign;
        this.customer_phone = customer_phone;
        this.user_id = user_id;
        this.total_price = total_price;
    }


    public Murad_Pharmacy_Modle(String med_name, int med_price, String med_image, String user_id, String order_id, String customer_address, String customer_name, String customer_sign, String customer_phone) {
        this.med_name = med_name;
        this.med_price = med_price;
        this.med_image = med_image;
        this.user_id = user_id;
        this.order_id = order_id;
        this.customer_address = customer_address;
        this.customer_name = customer_name;
        this.customer_sign = customer_sign;
        this.customer_phone = customer_phone;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
