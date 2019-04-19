package com.cmpe226.cafe.web;

import com.cmpe226.cafe.Drink;
import com.cmpe226.cafe.DrinkService;
import com.cmpe226.cafe.Message;
import com.cmpe226.cafe.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.mysql.cj.xdevapi.Type.JSON;


@RestController
public class DrinkController {

    @Autowired
    DrinkService drinkService;

//    @PostMapping("/saveDrink")
//    public List<Drink> save(
//                      @RequestParam long cus_id,
//                      @RequestParam String re_id,
//                      @RequestParam String ice_level,
//                      @RequestParam String sugar_level,
//                      //@RequestParam double price,
//                      @RequestParam String emp_id,
//                      @RequestParam String tea_name) {
//
//        Drink drink = new Drink();
//        drink.setEmp_id(emp_id);
//        drink.setIce_level(ice_level);
////        drink.setPrice(price);
//        drink.setSugar_level(sugar_level);
//        drink.setTea_name(tea_name);
//        //Orders order = new Orders();
//        List<Drink> drinks = new ArrayList<>();
//        drinks.add(drink);
//        return drinkService.saveAll(drinks , re_id, cus_id);
//    }
}
