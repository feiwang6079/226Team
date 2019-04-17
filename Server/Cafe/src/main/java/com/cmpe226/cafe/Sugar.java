package com.cmpe226.cafe;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sugar {
    @Id
    private String sugar_level;

    public Sugar(){}

    public Sugar(String sugar_level){
        this.sugar_level = sugar_level;
    }

    public String getSugar_level() {
        return sugar_level;
    }

    public void setSugar_level(String sugar_level) {
        this.sugar_level = sugar_level;
    }

    @Override
    public String toString() {
        return getSugar_level();

    }
}

