package com.cmpe226.cafe;

public class Order {
    private long order_id;
    private double total_price;
    private String status;

    public Order(long order_id, double total_price, String status) {
        this.order_id = order_id;
        this.total_price = total_price;
        this.status = status;
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
}