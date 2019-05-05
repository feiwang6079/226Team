package com.cmpe226.cafe.controllers;

import com.alibaba.fastjson.JSON;
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

    @GetMapping("/cafes")
    public Message customer(){
        List<Cafe> cafes = cafeRowMapper.findAllCafe();

        return new Message(200, "Success", JSON.toJSONString(cafes));
    }
}
