package com.cmpe226.cafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import lombok.extern.slf4j.Slf4j;

import javax.activation.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

//@EntityScan(basePackages = "com.cmpe226.cafe")
@SpringBootApplication
public class CafeApplication {



    public static void main(String[] args) {
        SpringApplication.run(CafeApplication.class, args);


    }



}
