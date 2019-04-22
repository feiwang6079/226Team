package com.cmpe226.cafe.notused;

import com.cmpe226.cafe.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


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
