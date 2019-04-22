//package com.cmpe226.cafe.web;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//@Repository
//@Service
//public class DrinkRowMapper extends BeanPropertyRowMapper {
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//    public int createDrink(String drink_id, String ice_level, String sugar_level,
//                       double price, String emp_id, String tea_name){
//        int r = 0;
//
//        String sql = "insert into drink values( drink_id, ice_level, sugar_level, price, emp_id, tea_name)";
//        try{
//            if(jdbcTemplate.update(sql) ==1 ) {
//                r = 1;
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return r;
//
//    }
//
//
//}
