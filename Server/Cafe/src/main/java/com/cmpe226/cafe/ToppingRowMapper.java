package com.cmpe226.cafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ToppingRowMapper extends BeanPropertyRowMapper {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Topping> findAllTps() {
        String sql = "select * from topping";

        List<Topping> tps = null;
        try {
            tps = (List<Topping>) jdbcTemplate.query(
                    sql,
                    new BeanPropertyRowMapper(Topping.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tps;
    }
}
