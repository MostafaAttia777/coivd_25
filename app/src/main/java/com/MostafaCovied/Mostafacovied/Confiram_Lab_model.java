package com.MostafaCovied.Mostafacovied;

public class Confiram_Lab_model {

    String order_id;
    String patient_age;
    String patient_name;
    String patient_phone;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
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

    public String getScan_name() {
        return scan_name;
    }

    public void setScan_name(String scan_name) {
        this.scan_name = scan_name;
    }

    public String getScan_price() {
        return scan_price;
    }

    public void setScan_price(String scan_price) {
        this.scan_price = scan_price;
    }

    public String getScan_reservation_time() {
        return scan_reservation_time;
    }

    public void setScan_reservation_time(String scan_reservation_time) {
        this.scan_reservation_time = scan_reservation_time;
    }

    public String getScan_waiting_time() {
        return scan_waiting_time;
    }

    public void setScan_waiting_time(String scan_waiting_time) {
        this.scan_waiting_time = scan_waiting_time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    String scan_name;

    public Confiram_Lab_model() {
    }

    String scan_price;
    String scan_reservation_time;
    String scan_waiting_time;
    String user_id;
int r;

    public Confiram_Lab_model(String scan_name, String scan_price, String scan_reservation_time, String scan_waiting_time, int r) {
        this.scan_name = scan_name;
        this.scan_price = scan_price;
        this.scan_reservation_time = scan_reservation_time;
        this.scan_waiting_time = scan_waiting_time;
        this.r = r;
    }

    public Confiram_Lab_model(String patient_age, String patient_name, String patient_phone, String user_id) {
        this.patient_age = patient_age;
        this.patient_name = patient_name;
        this.patient_phone = patient_phone;
        this.user_id = user_id;
    }
}
