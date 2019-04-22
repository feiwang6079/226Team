//package com.cmpe226.cafe.web;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//public class PaymentRowMapper extends BeanPropertyRowMapper {
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//    public void createOder(String order_id, String payment_id){
//        String sql = "insert into orders values(?1, ?2)";
//        try{
//            jdbcTemplate.update(
//                    sql,
//                    order_id, payment_id
//            );
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//}
