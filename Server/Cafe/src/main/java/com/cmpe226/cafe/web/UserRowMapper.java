//package com.cmpe226.cafe.web;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.List;
//import java.util.*;
//
//
//import com.cmpe226.cafe.Customer;
////import com.cmpe226.cafe.RepositoryDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//
//import javax.activation.DataSource;
//
//
//public class UserRowMapper extends BeanPropertyRowMapper {
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    private DataSource dataSource;
//
//
//    public Customer login(String id, String password) {
//        try {
//            Customer user = findByUserID(id);
//            if (user.getPassword().equals(password)) {
//                return user;
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//    public Customer findByUserID(String custId){
//        String sql = "SELECT * FROM User WHERE cus_id = ?";
//        Customer customer = null;
//        try{
//            customer = (Customer)jdbcTemplate.queryForObject(
//                    sql, new Object[] { custId },
//                    new BeanPropertyRowMapper(Customer.class));
//        } catch(Exception e){
//            e.printStackTrace();
//        }
//
//
//        return customer;
//    }
//
//
////    public List<Customer> findAll(){
////        String sql = "SELECT * FROM customer";
////        List<Customer> users = new ArrayList<>();
////        try{
////            users = this.jdbcTemplate.query("SELECT * FROM customer",
////                    new CusMapper());
////        }catch (Exception E){
////            E.printStackTrace();
////        };
////        return users;
////    }
//
//    public ArrayList<Customer> findAllUser() {
//        ArrayList<Customer> array = new ArrayList<Customer>();
//        try{
//            Statement s = RepositoryDAO.getInstance().myconn.createStatement();
//            ResultSet result = s.executeQuery("select * from customer");
//            while(result.next()){
//                Customer customer = new Customer();
//                customer.setCus_id(result.getString("cus_id"));
//                customer.setAccount_balance(result.getInt("account_balance"));
////                customer.setPassword(result.);
//                array.add(customer);
//            }
//        }catch (Exception e){}
//        return  array;
////    return this.jdbcTemplate.query( "select * from customer", new CusMapper());
//}
//
//    private static final class CusMapper implements RowMapper {
//
//        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//            Customer customer = new Customer();
//            customer.setCus_id(rs.getString("cus_id"));
//            customer.setPassword(rs.getString("password"));
//            customer.setPoints(rs.getInt("points"));
//            customer.setAccount_balance(rs.getInt("account_balance"));
//
//            return customer;
//        }
//    }
//
//
//}
