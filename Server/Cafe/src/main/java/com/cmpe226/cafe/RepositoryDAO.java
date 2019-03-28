//package com.cmpe226.cafe;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import javax.sql.DataSource;
//import java.sql.*;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.*;
//import java.util.Scanner;
//
//
//
//
////The @Repository annotation is used to create database repository for your Spring Boot application.
//@org.springframework.stereotype.Repository
//public class RepositoryDAO {
////    @Autowired
////    JdbcTemplate jdbcTemplate;
////    @Autowired
////    DataSource dataSource;
//
//    private static RepositoryDAO instance = new RepositoryDAO();
//    public Connection myconn;
//
//    private RepositoryDAO(){
//        String url = "jdbc:mysql://localhost:3306/cafe?serverTimezone=UTC";
//        String user = "root";
//        String password = "272716";
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            myconn = DriverManager.getConnection(url,user,password);
//
////
////            Statement mystatement = myconn.createStatement();
////
////            ResultSet rs = mystatement.executeQuery("Select * from orders");
////            System.out.println("orders dispaly all");
////            while (rs.next()) {
////                System.out.println(rs.getString("order_id"));
////
//        }catch (Exception e){
//        };
//
//    }
//
//    public static RepositoryDAO getInstance() {return instance; }
//
//
//}
////https://stackoverflow.com/questions/21956042/mapping-a-jdbc-resultset-to-an-object