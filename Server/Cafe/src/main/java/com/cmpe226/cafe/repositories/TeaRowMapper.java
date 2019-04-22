package com.cmpe226.cafe.repositories;

import com.cmpe226.cafe.models.Tea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TeaRowMapper extends BeanPropertyRowMapper {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Tea> findAllTea() {
        String sql = "select * from tea";

        List<Tea> teas = null;
        try {
            teas = (List<Tea>) jdbcTemplate.query(
                    sql,
                    new BeanPropertyRowMapper(Tea.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teas;
    }
}
