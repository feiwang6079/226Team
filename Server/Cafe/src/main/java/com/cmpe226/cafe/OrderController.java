package com.cmpe226.cafe;

import java.util.concurrent.atomic.AtomicLong;

import com.sun.tools.corba.se.idl.constExpr.Or;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    OrderResource orderResource = new OrderResource();

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/orders/{order_id}")
    public Order greeting(@PathVariable Long order_id) {
        Order order = orderResource.get(order_id);
        return order;
    }
}
