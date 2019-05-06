// SJSU CMPE 226 Spring 2019 TEAM1
package com.cmpe226.cafe.repositories;

import com.cmpe226.cafe.models.Sugar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SugarRowMapper extends BeanPropertyRowMapper {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Sugar> findAllSugar() {
        String sql = "select * from sugar";

        List<Sugar> sugars = null;
        try {
            sugars = (List<Sugar>) jdbcTemplate.query(
                    sql,
                    new BeanPropertyRowMapper(Sugar.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sugars;
    }

}
