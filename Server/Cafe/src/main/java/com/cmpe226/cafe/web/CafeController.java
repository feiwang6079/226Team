package com.cmpe226.cafe.web;

import com.cmpe226.cafe.Cafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CafeController {
    @Autowired
    CafeRowMapper cafeRowMapper;

    @GetMapping("/cafeTest")
    public List<Cafe> customer(){
        List<Cafe> cafes = cafeRowMapper.findAllCafe();
        return  cafes;
    }

}
