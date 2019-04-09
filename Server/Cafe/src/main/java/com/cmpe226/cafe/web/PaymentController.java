package com.cmpe226.cafe.web;

import com.cmpe226.cafe.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping("/savePayment")
    public Payment savePayment(@RequestParam long payment_id,
                               @RequestParam long order_id){
        Payment p = new Payment();
        p.setOrder_id(order_id);
        p.setPayment_id(payment_id);
        return paymentService.save(p);
    }
}
