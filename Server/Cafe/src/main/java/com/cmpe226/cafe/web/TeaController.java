package com.cmpe226.cafe.web;

import com.cmpe226.cafe.Tea;
import com.cmpe226.cafe.TeaRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeaController {
    @Autowired
    TeaRowMapper teaRowMapper;

    @GetMapping("/listAllTea")
    public List<Tea> listAllTea(){
        return teaRowMapper.findAllTea();
    }

}
