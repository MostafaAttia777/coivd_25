package com.MostafaCovied.Mostafacovied.CT_scan;

public class Model_for_CT_Scan {

    int scan_price;
    String scan_name;
    String waiting_time;

    public int getScan_price() {
        return scan_price;
    }

    public void setScan_price(int scan_price) {
        this.scan_price = scan_price;
    }

    public String getScan_name() {
        return scan_name;
    }

    public void setScan_name(String scan_name) {
        this.scan_name = scan_name;
    }

    public String getWaiting_time() {
        return waiting_time;
    }

    public void setWaiting_time(String waiting_time) {
        this.waiting_time = waiting_time;
    }

    public String getAvailable_time() {
        return Available_time;
    }

    public void setAvailable_time(String available_time) {
        Available_time = available_time;
    }

    public Model_for_CT_Scan(int scan_price, String scan_name, String waiting_time, String available_time) {
        this.scan_price = scan_price;
        this.scan_name = scan_name;
        this.waiting_time = waiting_time;
        Available_time = available_time;
    }

    String Available_time;



}
