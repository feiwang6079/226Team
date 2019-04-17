package com.cmpe226.cafe.web;

import com.cmpe226.cafe.Ice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IceController {
    @Autowired
    IceRowMapper iceRowMapper;

    @GetMapping("/listAllIce")
    public List<Ice> customer(){
        List<Ice> cafes = iceRowMapper.findAllIce();
        return  cafes;
    }
}
