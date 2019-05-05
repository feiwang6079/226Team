package com.cmpe226.cafe.models;

import java.sql.Time;
import java.util.List;

public class ClientOrders {

    private long order_id;
    private double total_price;
    private String status;
    private Time t;
    private long cus_id;
    private String re_id;

    private List<Drink> drinks;

    public ClientOrders(Orders order){
        this.total_price = order.getTotal_price();
        this.status = order.getStatus();
        this.order_id = order.getOrder_id();
        this.t = order.getT();
        this.cus_id = order.getCus_id();
        this.re_id = order.getRe_id();
    }

    public ClientOrders(long order_id, double total_price, String status, Time t, long cus_id, String re_id) {
        this.total_price = total_price;
        this.status = status;
        this.order_id = order_id;
        this.t = t;
        this.cus_id = cus_id;
        this.re_id = re_id;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Time getT() {
        return t;
    }

    public void setT(Time t) {
        this.t = t;
    }

    public long getCus_id() {
        return cus_id;
    }

    public void setCus_id(long cus_id) {
        this.cus_id = cus_id;
    }

    public String getRe_id() {
        return re_id;
    }

    public void setRe_id(String re_id) {
        this.re_id = re_id;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }
}
