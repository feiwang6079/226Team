package com.cmpe226.cafe.controllers;

//import UserRowMapper;
import com.cmpe226.cafe.services.CustomerService;
import com.cmpe226.cafe.models.Customer;
import com.cmpe226.cafe.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

////   @Autowired
////    UserRowMapper userRowMapper;
//    @Autowired
//    CustomerResource customerResource;

    @PostMapping("/login")
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

    @PostMapping("/payByBalance")
    public int payByBalance(@RequestParam long cus_id,
                               @RequestParam double total_price){

       return customerService.payByBalance(cus_id,total_price);
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

    @GetMapping("/review")
    public Customer review(@RequestParam long cus_id){
        return customerService.review(cus_id);
    }



    @PostMapping("/saveCustomer")
    public Customer saveCustomer(//@RequestParam long cus_id,
                                 @RequestParam String password,
                                 @RequestParam double points,
                                 @RequestParam double account_balance){
        Customer c = new Customer();
        c.setPoints( points);
        c.setPassword(password);
        c.setAccount_balance(account_balance);
        return customerService.saveCustomer(c);
    }

}
