package com.cmpe226.cafe.web;

import com.cmpe226.cafe.Cafe;
import com.cmpe226.cafe.Message;
import com.cmpe226.cafe.Sugar;
import com.cmpe226.cafe.SugarRowMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SugarController {

    @Autowired
    SugarRowMapper sugarRowMapper;

    @GetMapping("/listAllSugar")
    public Message listAllSugar() {

        List<Sugar> sugars = sugarRowMapper.findAllSugar();

        String data;
        ObjectMapper mapper = new ObjectMapper();
        try {
            data = mapper.writeValueAsString(sugars);
        } catch (Exception e) {
            data = "";
        }

        return new Message(200, "Success", data);
    }

}
