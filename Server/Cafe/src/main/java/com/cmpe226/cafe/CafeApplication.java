package com.cmpe226.cafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;
import java.util.Scanner;
import com.mysql.cj.jdbc.Driver;

@SpringBootApplication
public class CafeApplication {

    public static void main(String[] args) throws SQLException{
//        SpringApplication.run(CafeApplication.class, args);
        String url = "jdbc:mysql://localhost:3306/cafe";
        String user = "root";
        String password = "272716";
        Connection myconn;
        try  {
            myconn = DriverManager.getConnection(url, user, password);


            Statement mystatement = myconn.createStatement();

            ResultSet rs = mystatement.executeQuery("Select * from orders");
            System.out.println("orders dispaly all");
            while (rs.next()) {
                System.out.println(rs.getString("order_id"));
            }

        }catch (SQLException e){};


    }

}
