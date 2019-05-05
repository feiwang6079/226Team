package com.cmpe226.cafe.models;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;

@Entity
@NamedStoredProcedureQuery(
        name = "PAY",
        procedureName = "PAY",
        parameters = {
                @StoredProcedureParameter(name = "my_cus_id", mode = ParameterMode.IN, type = Long.class),
                @StoredProcedureParameter(name = "my_order_id", mode = ParameterMode.IN, type = Long.class),
                @StoredProcedureParameter(name = "message", mode = ParameterMode.OUT, type = String.class),
        }
)
public class Customer {
    @Id
    private long cus_id;
    private String password;
    private double points;
    private double account_balance;

    public Customer( String password, double points, double account_balance) {

        this.password = password;
        this.points = points;
        this. account_balance = account_balance;
    }

    public Customer() {
    }

    public Customer(long cus_id){
        this.cus_id = cus_id;
    }

    public long getCus_id() {
        return cus_id;
    }

    public void setCus_id(long cus_id) {
        this.cus_id = cus_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public double getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(double account_balance) {
        this.account_balance = account_balance;
    }
}
