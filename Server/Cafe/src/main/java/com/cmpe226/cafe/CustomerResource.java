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
import org.springframework.stereotype.Service;

import javax.activation.DataSource;
@Repository
@Service
public class CustomerResource {

    @Autowired
    public JdbcTemplate jdbcTemplate;
//    @Autowired
//    DataSource dataSource;

    private Map<String, Customer> users = new HashMap<String, Customer>();
    private long nextId = 0;

    public CustomerResource(){
    }

//    public void create(User user) {
//        users.put(user.getCus_id(), user);
//    }

    public Customer get(String id) {
        String sql = "select * from customer where cus_id = '" + id + "'";

        //Customer customer = jdbcTemplate.queryForObject(sql, Customer.class);
        Customer customer = (Customer)jdbcTemplate.queryForObject(
                sql, new Object[] { },
                new BeanPropertyRowMapper(Customer.class));
        System.out.println(customer);
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

    public Customer login(String id, String password) {
        Customer user = users.get(id);
        if (user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
