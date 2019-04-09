package com.cmpe226.cafe;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ice {
    @Id
    private String ice_level;

    public Ice(){}

    public Ice(String ice_level){
        this.ice_level = ice_level;
    }

    public String getIce_level() {
        return ice_level;
    }

    public void setIce_level(String ice_level) {
        this.ice_level = ice_level;
    }

    @Override
    public String toString() {
        return getIce_level();
    }
}
