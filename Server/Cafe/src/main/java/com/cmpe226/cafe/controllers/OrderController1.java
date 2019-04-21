package com.cmpe226.cafe.controllers;

import com.cmpe226.cafe.models.Message;
import com.cmpe226.cafe.models.Orders;
import com.cmpe226.cafe.services.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController1 {
    @Autowired
    OrderService orderService;

    @GetMapping("/saveOrder")
    public Message listUserOrders(//@RequestParam long order_id,
                                  @RequestParam double total_price,
                                  //@RequestParam String status,
                                  //@RequestParam Timestamp t,
                                  @RequestParam long cus_id,
                                  @RequestParam String re_id  ){

            Orders o = new Orders();
            o.setTotal_price(total_price);
            o.setCus_id(cus_id);
            o.setRe_id(re_id);
            //o.setT(System.currentTimeMillis());
            o.setStatus("unpaid");
            Orders a = orderService.save(o);
            ObjectMapper mapper = new ObjectMapper();
            String data = "";
            try{
                data = mapper.writeValueAsString(a);
            }catch (Exception e){
                data = "";
            }

            return new Message(200, "Success", data);
    }

    @GetMapping("/listUserOrders")
    public List<Orders> listUserOrders(@RequestParam long cus_id){
        return orderService.reviewMyOrders(cus_id);

    }




}
