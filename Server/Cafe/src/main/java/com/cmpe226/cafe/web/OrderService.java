package com.cmpe226.cafe.web;

import com.cmpe226.cafe.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Orders> reviewMyOrders(long cus_id) {
        return orderRepository.reviewMyOrders(cus_id);
    }

    public int pay(long order_id){
        return orderRepository.pay(order_id);
        }

    public Orders save(Orders orders){
       return  orderRepository.save(orders);
    }
}
