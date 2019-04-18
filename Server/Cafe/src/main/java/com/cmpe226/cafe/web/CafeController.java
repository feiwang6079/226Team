package com.cmpe226.cafe.web;

import com.cmpe226.cafe.Cafe;
import com.cmpe226.cafe.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
