package com.cmpe226.cafe;

public class Customer {
    private String cus_id;
    private String password;
    private int points;
    private int account_balance;

    public Customer(String cus_id, String password) {
        this.cus_id = cus_id;
        this.password = password;
        this.points = 0;
        this. account_balance = 0;
    }
    public Customer() {
    }

    @Override
    public String toString() {
        return getCus_id() +"   " + getAccount_balance() + getPoints();
    }

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(int account_balance) {
        this.account_balance = account_balance;
    }
}
