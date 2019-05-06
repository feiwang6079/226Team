// SJSU CMPE 226 Spring 2019 TEAM1
package com.cmpe226.cafe.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    private String emp_id;
    private String name;
    private String gender;
    private String re_id;

    public Employee(){}

    public Employee(String emp_id,String name,String gender,String re_id){
        this.emp_id = emp_id;
        this.name = name;
        this.gender = gender;
        this.re_id = re_id;
    }

    public String getRe_id() {
        return re_id;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public void setRe_id(String re_id) {
        this.re_id = re_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getEmp_id() + " "+ getGender() +" " +getRe_id()+" " + getName();
    }
}
