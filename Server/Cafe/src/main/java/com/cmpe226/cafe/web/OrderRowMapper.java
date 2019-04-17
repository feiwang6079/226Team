//package com.cmpe226.cafe.web;
//
//import com.cmpe226.cafe.Topping;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.sql.Timestamp;
//import java.util.List;
//
//public class OrderRowMapper extends BeanPropertyRowMapper {
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    public List<Topping> findAllIce() {
//        String sql = "select * from ice";
//
//        List<Topping> toppings = null;
//        try {
//            toppings = (List<Topping>) jdbcTemplate.query(
//                    sql,
//                    new BeanPropertyRowMapper(Topping.class));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return toppings;
//    }
//
//    public String createOder(String order_id, double total_price, String status, Timestamp t){
//        String sql = "insert into orders values(?1, ?2, ?3, ?4)";
//        String res = "Failed to update";
//        try{
//            if(jdbcTemplate.update(sql, order_id, total_price, status, t) == 0 ) {
//                res = order_id;
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return res;
//    }
//
//
//}
