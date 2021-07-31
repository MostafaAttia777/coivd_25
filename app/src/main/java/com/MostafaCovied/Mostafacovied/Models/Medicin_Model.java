package com.MostafaCovied.Mostafacovied.Models;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Medicin_Model extends ArrayList<Medicin_Model> {
    private String med_name;
    private String med_descraption;
    private int med_price;
    private String med_image;
    String user_id;
   private String order_id;
    String count;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }


    public String getMult() {
        return mult;
    }

    public void setMult(String mult) {
        this.mult = mult;
    }

    String mult;

    public Medicin_Model(String med_name, String med_image, String count,String mult) {
        this.med_name = med_name;
        this.med_image = med_image;
        this.count = count;
        this.mult=mult;
    }


    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Medicin_Model(String med_name) {
        this.med_name = med_name;
    }


    public Medicin_Model(String med_name, String med_descraption, int med_price, String med_image) {
        this.med_name = med_name;
        this.med_descraption = med_descraption;
        this.med_price = med_price;
        this.med_image = med_image;
    }


    public String getMed_name() {
        return med_name;
    }

    public void setMed_name(String med_name) {
        this.med_name = med_name;
    }

    public String getMed_descraption() {
        return med_descraption;
    }

    public void setMed_descraption(String med_descraption) {
        this.med_descraption = med_descraption;
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

    @NonNull
    @Override
    public Stream<Medicin_Model> stream() {
        return null;
    }
}
