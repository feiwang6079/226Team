package com.cmpe226.cafe.web;

import com.cmpe226.cafe.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    private OrderRepository orderRepository;

    @Transactional
    public Payment save(Payment payment, long order_id) {
        orderRepository.pay(order_id);
        return paymentRepository.save(payment);
    }
}
