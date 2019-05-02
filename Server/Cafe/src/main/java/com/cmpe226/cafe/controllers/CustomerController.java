package com.cmpe226.cafe.controllers;

import com.cmpe226.cafe.models.Orders;
import com.cmpe226.cafe.models.Payment;
import com.cmpe226.cafe.services.CustomerService;
import com.cmpe226.cafe.models.Customer;
import com.cmpe226.cafe.models.Message;
import com.cmpe226.cafe.services.OrderService;
import com.cmpe226.cafe.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    OrderService orderService;

    @Autowired
    PaymentService paymentService;

    @GetMapping("/login")
    public Message review(@RequestParam long cus_id, @RequestParam String password){
        Customer c =  customerService.review(cus_id);

        if (c == null) {
            return new Message(401, "User not found", "");
        } else if(c.getPassword().toLowerCase().equals(password.toLowerCase())) {
            return new Message(200, "Success", c.toString());
        } else {
            return new Message(402, "Wrong password", "");
        }
    }

    @GetMapping("/topup")
    public Message topUp(@RequestParam long cus_id,
                         @RequestParam double value){

        int result = customerService.topUp(cus_id, value);
        if (result == 1) {
            return new Message(200, "Success", "");
        } else {
            return new Message(400, "Failed", "");
        }
    }

    @GetMapping("/pay")
    public Message pay(@RequestParam long cus_id,
                         @RequestParam long order_id){

        Customer customer = customerService.review(cus_id);
        Orders orders = orderService.getOrder(order_id);
        if (customer.getAccount_balance() < orders.getTotal_price()) {
            return new Message(400, "No enough balance", "");
        }

        customerService.payByBalance(cus_id, orders.getTotal_price());

        Payment payment = new Payment();
        payment.setOrders(orders);
        paymentService.save(payment, order_id);

        return new Message(200, "Success", "");
    }

    @GetMapping("/getmoney")
    public Message money(@RequestParam long cus_id){
        double balance = customerService.getAccountBalance(cus_id);
        return new Message(200, "Success", String.valueOf(balance));
    }


//    @PostMapping("/payByBalance")
//    public int payByBalance(@RequestParam long cus_id,
//                               @RequestParam double total_price){
//
//       return customerService.payByBalance(cus_id,total_price);
//    }

//    @GetMapping("/review")
//    public Customer review(@RequestParam long cus_id){
//        return customerService.review(cus_id);
//    }

//    @PostMapping("/saveCustomer")
//    public Customer saveCustomer(//@RequestParam long cus_id,
//                                 @RequestParam String password,
//                                 @RequestParam double points,
//                                 @RequestParam double account_balance){
//        Customer c = new Customer();
//        c.setPoints( points);
//        c.setPassword(password);
//        c.setAccount_balance(account_balance);
//        return customerService.saveCustomer(c);
//    }
}
