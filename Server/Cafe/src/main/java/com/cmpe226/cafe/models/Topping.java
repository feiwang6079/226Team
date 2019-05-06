// SJSU CMPE 226 Spring 2019 TEAM1
package com.cmpe226.cafe.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topping {
    @Id
    private String topping_name;
    private double price;

    public Topping(String topping_name, double price){
        this.topping_name = topping_name;
        this.price = price;
    }

    public Topping(){

    }

    @Override
    public String toString() {
        return getTopping_name() +"   " + getPrice();
    }


    public String getTopping_name() {
        return topping_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTopping_name(String topping_name) {
        this.topping_name = topping_name;
    }
}



