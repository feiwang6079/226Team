package com.cmpe226.cafe.web;

import com.cmpe226.cafe.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class OrderController1 {
    @Autowired
    OrderService orderService;

    @PostMapping("/saveOrder")
    public Orders listUserOrders(//@RequestParam long order_id,
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

            return orderService.save(o);
    }

    @GetMapping("/listUserOrders")
    public List<Orders> listUserOrders(@RequestParam long cus_id){
        return orderService.reviewMyOrders(cus_id);

    }




}
