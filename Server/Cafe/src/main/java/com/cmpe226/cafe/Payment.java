package com.cmpe226.cafe;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Payment {
    @Id
    private long payment_id;
    private long order_id;

    public Payment(long payment_id, long order_id){
        this.order_id = order_id;
        this.payment_id = payment_id;
    }

    public Payment(){

    }

    public long getOrder_id() {
        return order_id;
    }

    public long getPayment_id() {
        return payment_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public void setPayment_id(long payment_id) {
        this.payment_id = payment_id;
    }

    @Override
    public String toString() {
        return getOrder_id() + " " + getPayment_id();
    }
}




