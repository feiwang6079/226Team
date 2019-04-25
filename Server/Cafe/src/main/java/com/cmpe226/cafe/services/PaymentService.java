package com.cmpe226.cafe.services;

import com.cmpe226.cafe.models.Payment;
import com.cmpe226.cafe.repositories.OrderRepository;
import com.cmpe226.cafe.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Payment save(Payment payment, long order_id) {
        orderRepository.pay(order_id);
        return paymentRepository.save(payment);
    }
}
