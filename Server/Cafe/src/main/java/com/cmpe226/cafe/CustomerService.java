package com.cmpe226.cafe;

import com.cmpe226.cafe.Customer;
import com.cmpe226.cafe.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public int payByBalance(long cus_id, double total_price){
        return customerRepository.payByBalance(cus_id, total_price);
    }

    public int topUp(long cus_id, double value){
        return customerRepository.topUp(cus_id, value);
    }

    public Customer review(long cus_id){
        return customerRepository.review(cus_id);
    }

    public Customer saveCustomer(Customer c){
        return customerRepository.save(c);
    }
}
