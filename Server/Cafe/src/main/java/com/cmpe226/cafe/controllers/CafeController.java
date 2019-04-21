package com.cmpe226.cafe.controllers;

import com.cmpe226.cafe.models.Cafe;
import com.cmpe226.cafe.models.Message;
import com.cmpe226.cafe.repositories.CafeRowMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CafeController {
    @Autowired
    CafeRowMapper cafeRowMapper;

    @GetMapping("/cafe")
    public Message customer(){
        List<Cafe> cafes = cafeRowMapper.findAllCafe();

        String data;
        ObjectMapper mapper = new ObjectMapper();
        try {
            data = mapper.writeValueAsString(cafes);
        } catch (Exception e) {
            data = "";
        }

        return new Message(200, "Success", data);
    }
}
