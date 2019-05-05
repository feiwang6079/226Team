package com.cmpe226.cafe.services;

import com.cmpe226.cafe.models.ClientOrders;
import com.cmpe226.cafe.models.Orders;
import com.cmpe226.cafe.repositories.CustomerRepository;
import com.cmpe226.cafe.models.Payment;
import com.cmpe226.cafe.repositories.OrderRepository;
import com.cmpe226.cafe.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PaymentRepository paymentRepository;


    public List<Orders> reviewMyOrders(long cus_id) {
        return orderRepository.reviewMyOrders(cus_id);
    }


    public Orders getOrder(long order_id) {
        return orderRepository.getOrder(order_id);
    }

    @Transactional
    public Payment pay(long order_id){
        Optional<Orders> theOrder = orderRepository.findById(order_id);
        Orders orders = null;
        if(theOrder.isPresent()){
             orders = theOrder.get();
        }else{
             orders = new Orders();
        }
//        customerRepository.topUp(orders.getCus_id(),  orders.getTotal_price() );
        customerRepository.payByBalance(orders.getCus_id(), orders.getTotal_price());
        Payment payment = new Payment();
        payment.setOrders(orders);
        return paymentRepository.save(payment);
        }

    public int save(ClientOrders orders){
       return orderRepository.insertOrders(orders.getOrder_id(), orders.getTotal_price(), orders.getStatus(), orders.getT(),
                                            orders.getCus_id(), orders.getRe_id());
    }

    public Orders update(Orders orders){
        return orderRepository.save(orders);
    }

    public long getOrderCount(){
        return orderRepository.getOrderCount();
    }
}
