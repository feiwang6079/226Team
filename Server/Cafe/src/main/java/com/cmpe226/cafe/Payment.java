package com.cmpe226.cafe;

import javax.persistence.*;

@Entity
public class Payment {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long payment_id;
    @OneToOne
    private Orders orders;

//    public Payment(long payment_id, long ){
//        this.order_id = order_id;
//        this.payment_id = payment_id;
//    }

    public Payment(){

    }

//    public long getOrder_id() {
//        return order_id;
//    }

    public long getPayment_id() {
        return payment_id;
    }

//    public void setOrder_id(long order_id) {
//        this.order_id = order_id;
//    }

    public void setPayment_id(long payment_id) {
        this.payment_id = payment_id;
    }

//    @Override
//    public String toString() {
//        return getOrder_id() + " " + getPayment_id();
//    }

    public Orders getOrders(){
        return this.orders;
    }

    public void setOrders(Orders orders){
        this.orders = orders;
    }

}

