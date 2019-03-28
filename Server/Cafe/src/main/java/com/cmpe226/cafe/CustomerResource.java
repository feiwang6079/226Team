package com.cmpe226.cafe;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.activation.DataSource;
@Repository
public class CustomerResource {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private Map<String, Customer> users = new HashMap<String, Customer>();
    private long nextId = 0;

    public CustomerResource(){
    }

//    public void create(User user) {
//        users.put(user.getCus_id(), user);
//    }

    public Customer get(String id) {
        jdbcTemplate.execute("insert into customer values('1203456780', 234, 423.2, '25f9e794323b453885f5181f1b624d0b');\n");

        String sql = "select * from customer where cus_id = '" + id + "'";
        System.out.println(sql);
        System.out.println(jdbcTemplate);
        Customer customer = jdbcTemplate.queryForObject(sql, Customer.class);

        return customer;

    }
//        Customer customer = new Customer();
//        try{
//            Statement s = RepositoryDAO.getInstance().myconn.createStatement();
//            String sql = "select * from customer where cus_id = '" + id + "'";
//            ResultSet result = s.executeQuery(sql);
//
//            ResultSetMetaData metaData = result.getMetaData();
//            int cols = metaData.getColumnCount();
//            while(result.next()){
////                customer.setCus_id(result.getString("cus_id"));
////                customer.setAccount_balance(result.getInt("account_balance"));
////                customer.setPassword(result.getString("password"));
////                customer.setPoints(result.getInt("points"));
//                Map<String, Object> rowData = new HashMap<String, Object>();
//                for(int i = 1; i <= cols; i++){
//                    rowData.put(metaData.getCatalogName(i), result.getObject(i));
//                }
//
//            }
//        }catch (Exception e){}
//        return  customer;
//    }
////
//    public void delete(String id) {
//        users.remove(id);
//    }

//    public void update(String id, User user) {
//        users.put(id, user);
//    }

//    public User login(String id, String password) {
//        User user = users.get(id);
//        if (user.getPassword().equals(password)) {
//            return user;
//        }
//        return null;
//    }
}
