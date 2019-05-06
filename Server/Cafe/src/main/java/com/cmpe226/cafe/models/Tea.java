// SJSU CMPE 226 Spring 2019 TEAM1
package com.cmpe226.cafe.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tea {
    @Id
    private String tea_name;
    private double price;

    public Tea(String tea_name, double price){
        this.tea_name = tea_name;
        this.price = price;
    }

    public Tea(){}



    public String getTea_name() {
        return tea_name;
    }

    public double getPrice() {
        return price;
    }

    public void setTea_name(String tea_name) {
        this.tea_name = tea_name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getTea_name() + " " + getPrice();
    }
}
