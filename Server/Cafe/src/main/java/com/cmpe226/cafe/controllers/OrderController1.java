package com.cmpe226.cafe.controllers;

import com.cmpe226.cafe.models.Drink;
import com.cmpe226.cafe.models.Message;
import com.cmpe226.cafe.models.Orders;
import com.cmpe226.cafe.repositories.TeaService;
import com.cmpe226.cafe.services.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController1 {
    @Autowired
    OrderService orderService;

    @Autowired
    private TeaService teaService;

    @PostMapping("/orders")
    public Message createOrder(//@RequestParam long order_id,
//                                  @RequestParam double total_price,
                                  //@RequestParam String status,
                                  //@RequestParam Timestamp t,
//                                  @RequestBody long cus_id,
//                                  @RequestBody String re_id,
//                               @RequestBody String drinks_json
                               @RequestBody Orders orders
                               ) {

//        Orders orders = new Orders();
//        orders.setCus_id(cus_id);
//        orders.setRe_id(re_id);
//        orders.setStatus("unpaid");
//
//        List<Drink> drinks = new ArrayList<>();
//        Drink d1 = new Drink("50%", "30%",
//                23, "emp_01", "Tieguanyin", "boba");
//        d1.saveOrders(orders);
//        drinks.add(d1);
//        Drink d2 = new Drink("0%", "0%",
//                23, "emp_01", "Tieguanyin", "boba");
//        d2.saveOrders(orders);
//        drinks.add(d2);
//        orders.saveDrinks(drinks);
//
//
//        double total_price = 0;
//        for(Drink d: drinks) {
//            total_price += teaService.findByTeaName(d.getTea_name()).getPrice();
//        }
//        orders.setTotal_price(total_price);
//
        orders = orderService.save(orders);

        ObjectMapper mapper = new ObjectMapper();
        String data = "";
        try {
            data = mapper.writeValueAsString(orders);
        } catch (Exception e) {
            data = "";
        }

        return new Message(200, "Success", data);
    }

    @GetMapping("/orders")
    public Message listUserOrders(@RequestParam long cus_id){
        List<Orders> orders = orderService.reviewMyOrders(cus_id);

        ObjectMapper mapper = new ObjectMapper();
        String data = "";
        try{
            data = mapper.writeValueAsString(orders);
        }catch (Exception e){
            e.printStackTrace();
            data = "";
        }

        return new Message(200, "Success", data);
    }
}
