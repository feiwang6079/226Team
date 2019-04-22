package com.cmpe226.cafe.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cafe {
    @Id
    @GeneratedValue
    private String re_id;
    private String location;

    public Cafe() {
    }

    public Cafe(String re_id, String location) {
        this.location = location;
        this.re_id = re_id;
    }

    //getters
    public String getRe_id() {
        return re_id;
    }

    public String getLocation() {
        return location;
    }

    //setters
    public void setRe_id(String re_id) {
        this.re_id = re_id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    //print
    @Override
    public String toString() {
        return getRe_id() + "  " + getLocation();
    }
}
