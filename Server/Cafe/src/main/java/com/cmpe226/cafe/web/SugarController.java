package com.cmpe226.cafe.web;

import com.cmpe226.cafe.Sugar;
import com.cmpe226.cafe.SugarRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SugarController {
    @Autowired
    SugarRowMapper sugarRowMapper;

    @GetMapping("/listAllSugar")
    public List<Sugar> listAllSugar(){
        return sugarRowMapper.findAllSugar();
    }
}
