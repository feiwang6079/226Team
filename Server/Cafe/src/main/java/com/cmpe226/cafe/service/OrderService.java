package com.cmpe226.cafe.service;

import com.cmpe226.cafe.Orders;
import com.cmpe226.cafe.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Orders> findAll(){
        return orderRepository.findAll();
    }

    public Orders save(Orders ord){
        return orderRepository.save(ord);
    }

    public Optional<Orders> getOne(long id){
        return orderRepository.findById(id);
    }

    public void delete(long id){
        orderRepository.deleteById(id);
    }
}
