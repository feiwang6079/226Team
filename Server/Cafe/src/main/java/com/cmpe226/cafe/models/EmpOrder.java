// SJSU CMPE 226 Spring 2019 TEAM1
package com.cmpe226.cafe.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_order")
public class EmpOrder {

    @Id
    private String emp_id;
    private String tea_name;
    private long order_id;
    private long cus_id;
    private  String status;

    public EmpOrder(){};

    public EmpOrder(String emp_id, String tea_name, long order_id, long cus_id) {
        this.emp_id = emp_id;
        this.tea_name = tea_name;
        this.order_id = order_id;
        this.cus_id = cus_id;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getTea_name() {
        return tea_name;
    }

    public void setTea_name(String tea_name) {
        this.tea_name = tea_name;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public double getCus_id() {
        return cus_id;
    }

    public void setCus_id(long cus_id) {
        this.cus_id = cus_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
