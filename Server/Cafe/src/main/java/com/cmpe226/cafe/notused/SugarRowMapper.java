//package com.cmpe226.cafe.web;
//
//import com.cmpe226.cafe.models.Sugar;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.util.List;
//
//public class sugarRowMapper extends BeanPropertyRowMapper {
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    public List<Sugar> findAllIce() {
//        String sql = "select * from sugar";
//
//        List<Sugar> sugars = null;
//        try {
//            sugars = (List<Sugar>) jdbcTemplate.query(
//                    sql,
//                    new BeanPropertyRowMapper(Sugar.class));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return sugars;
//    }
//}
