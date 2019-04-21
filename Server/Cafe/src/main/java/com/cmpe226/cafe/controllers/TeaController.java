package com.cmpe226.cafe.controllers;

import com.cmpe226.cafe.models.Message;
import com.cmpe226.cafe.models.Tea;
import com.cmpe226.cafe.repositories.TeaRowMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeaController {
    @Autowired
    TeaRowMapper teaRowMapper;

    @GetMapping("/tea")
    public Message listAllTea(){

        List<Tea> teas = teaRowMapper.findAllTea();
        String data;
        ObjectMapper mapper = new ObjectMapper();
        try {
            data = mapper.writeValueAsString(teas);
        } catch (Exception e) {
            data = "";
        }
        return new Message(200, "Success", data);
    }

}
