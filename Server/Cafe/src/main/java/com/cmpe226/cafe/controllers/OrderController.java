package com.cmpe226.cafe.controllers;

import com.cmpe226.cafe.models.Drink;
import com.cmpe226.cafe.models.Message;
import com.cmpe226.cafe.models.Orders;
import com.cmpe226.cafe.services.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/orders")
    public Message createOrder(
                               @RequestBody Orders orders
                               ) {

        List<Drink> drinks = orders.getDrinks();
        for (Drink drink : drinks) {
            drink.saveOrders(orders);
            drink.setEmp_id(getEmployID());
        }

        orders.setStatus("unpaid");
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

    private String getEmployID(){
        return "emp_01";
    }

    @GetMapping("/getorders")
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
