package com.cmpe226.cafe.web;

import com.cmpe226.cafe.Drink;
import com.cmpe226.cafe.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DrinkController {
    @Autowired
    DrinkService drinkService;

    @PostMapping("/drinks")
    public Drink save(
                      @RequestParam String json){
//       Drink drink = new Drink(drink_id, ice_level,sugar,
//               price, emp_id, tea_name);
        Drink drink = new Drink();
//        //drink.setDrink_id(drink_id);
//        drink.setEmp_id(emp_id);
//        drink.setIce_level(ice_level);
//        drink.setPrice(price);
//        drink.setSugar_level(sugar_level);
//        drink.setTea_name(tea_name);
        return drinkService.save(drink);
    }
}
