// SJSU CMPE 226 Spring 2019 TEAM1
package com.cmpe226.cafe.controllers;

import com.alibaba.fastjson.JSON;
import com.cmpe226.cafe.models.ClientOrders;
import com.cmpe226.cafe.models.Drink;
import com.cmpe226.cafe.models.Message;
import com.cmpe226.cafe.models.Orders;
import com.cmpe226.cafe.services.DrinkService;
import com.cmpe226.cafe.services.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    DrinkService drinkService;

    @PostMapping("/orders")
    public Message createOrder(
                               @RequestBody ClientOrders orders
                               ) {
        try{
            Boolean n = insertOrder(orders);
        }catch (Exception e){
            return new Message(400, "Insert Error", "");
        }
        return new Message(200, "Success", JSON.toJSONString(orders));
    }

    @Transactional
    public Boolean insertOrder(ClientOrders orders) throws Exception{

        orders.setStatus("unpaid");

        long num = orderService.getOrderCount();
        orders.setOrder_id(num + 1);

        int isSuccess = orderService.save(orders);
        List<Drink> drinks = orders.getDrinks();
        for (Drink drink : drinks) {
            drink.setOrder_id(num + 1);
            drink.setEmp_id(getEmployID());
            drinkService.save(drink);
        }

        return true;
    }

    private String getEmployID(){
        return "emp_01";
    }

    @GetMapping("/getorders")
    public Message listUserOrders(@RequestParam long cus_id){
        List<Orders> orders = orderService.reviewMyOrders(cus_id);
        List<ClientOrders> clientOrders = new ArrayList<ClientOrders>();
        for(Orders order : orders){
            List<Drink> drinks = drinkService.getDrinks(order.getOrder_id());
            ClientOrders newOrder = new ClientOrders(order);
            newOrder.setDrinks(drinks);
            clientOrders.add(newOrder);
        }
        return new Message(200, "Success", JSON.toJSONString(clientOrders));
    }
}
