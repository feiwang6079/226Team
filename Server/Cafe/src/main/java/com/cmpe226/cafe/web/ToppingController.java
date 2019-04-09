package com.cmpe226.cafe.web;

import com.cmpe226.cafe.Topping;
import com.cmpe226.cafe.ToppingRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToppingController {

    @Autowired
    ToppingRowMapper toppingRowMapper;
    @GetMapping("/listAllToppings")
    public List<Topping> listAllToppings(){
        return toppingRowMapper.findAllTps();
    }
}
