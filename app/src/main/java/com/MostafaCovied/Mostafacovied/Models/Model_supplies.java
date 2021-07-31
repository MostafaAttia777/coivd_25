package com.MostafaCovied.Mostafacovied.Models;

public class Model_supplies {

    String supp_name;
    int supp_price;
    String supp_image;

    public String getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(String order_Id) {
        this.order_Id = order_Id;
    }

    String order_Id;
    String user_id;

    public String getSupp_name() {
        return supp_name;
    }

    public void setSupp_name(String supp_name) {
        this.supp_name = supp_name;
    }

    public int getSupp_price() {
        return supp_price;
    }

    public void setSupp_price(int supp_price) {
        this.supp_price = supp_price;
    }

    public String getSupp_image() {
        return supp_image;
    }

    public void setSupp_image(String supp_image) {
        this.supp_image = supp_image;
    }

    public Model_supplies() {
    }

    public Model_supplies(String supp_name, int supp_price, String supp_image) {
        this.supp_name = supp_name;
        this.supp_price = supp_price;
        this.supp_image = supp_image;
    }

    public Model_supplies(String supp_name, int supp_price, String supp_image, String order_Id,String user_id) {
        this.supp_name = supp_name;
        this.supp_price = supp_price;
        this.supp_image = supp_image;
        this.order_Id = order_Id;
        this.user_id=user_id;
    }
}
