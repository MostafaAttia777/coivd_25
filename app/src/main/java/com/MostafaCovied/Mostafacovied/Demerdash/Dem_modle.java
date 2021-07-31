package com.MostafaCovied.Mostafacovied.Demerdash;

public class Dem_modle {

    String kind;
    String order_id;
    String patient_address;
    String patient_age;
    String patient_name;
    String patient_phone;
    String user_id;

    public Dem_modle(String kind, String patient_address, String patient_age, String patient_name, String patient_phone, String user_id) {

    }

    public Dem_modle(String patient_address, String patient_name, String patient_phone, String user_id) {
        this.patient_address = patient_address;
        this.patient_name = patient_name;
        this.patient_phone = patient_phone;
        this.user_id = user_id;
    }

    public Dem_modle(String kind, String patient_address, String patient_age, String patient_name, String patient_phone) {
        this.kind = kind;
        this.patient_address = patient_address;
        this.patient_age = patient_age;
        this.patient_name = patient_name;
        this.patient_phone = patient_phone;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getPatient_address() {
        return patient_address;
    }

    public void setPatient_address(String patient_address) {
        this.patient_address = patient_address;
    }

    public String getPatient_age() {
        return patient_age;
    }

    public void setPatient_age(String patient_age) {
        this.patient_age = patient_age;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_phone() {
        return patient_phone;
    }

    public void setPatient_phone(String patient_phone) {
        this.patient_phone = patient_phone;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


}
