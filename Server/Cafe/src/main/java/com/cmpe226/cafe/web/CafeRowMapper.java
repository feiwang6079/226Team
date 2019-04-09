package com.cmpe226.cafe.web;

import com.cmpe226.cafe.Cafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Repository
@Service
public class CafeRowMapper extends BeanPropertyRowMapper {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Cafe> findAllCafe() {
        String sql = "select * from cafe";

        List<Cafe> cafes = null;
        try {
            cafes = (List<Cafe>) jdbcTemplate.query(
                    sql,
                    new BeanPropertyRowMapper(Cafe.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cafes;
    }
}
