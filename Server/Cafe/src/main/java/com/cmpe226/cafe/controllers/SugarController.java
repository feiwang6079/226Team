// SJSU CMPE 226 Spring 2019 TEAM1
package com.cmpe226.cafe.controllers;

import com.alibaba.fastjson.JSON;
import com.cmpe226.cafe.models.Message;
import com.cmpe226.cafe.models.Sugar;
import com.cmpe226.cafe.repositories.SugarRowMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SugarController {

    @Autowired
    SugarRowMapper sugarRowMapper;

    @GetMapping("/sugar_types")
    public Message listAllSugar() {

        List<Sugar> sugars = sugarRowMapper.findAllSugar();

        return new Message(200, "Success", JSON.toJSONString(sugars));
    }
}
