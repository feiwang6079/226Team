// SJSU CMPE 226 Spring 2019 TEAM1
package com.cmpe226.cafe.repositories;

import com.cmpe226.cafe.models.Ice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class IceRowMapper extends BeanPropertyRowMapper {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Ice> findAllIce() {
        String sql = "select * from ice";

        List<Ice> ices = null;
        try {
            ices = (List<Ice>) jdbcTemplate.query(
                    sql,
                    new BeanPropertyRowMapper(Ice.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ices;
    }
}

