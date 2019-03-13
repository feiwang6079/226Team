package com.cmpe226.cafe;

import java.util.concurrent.atomic.AtomicLong;

import com.sun.tools.corba.se.idl.constExpr.Or;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {

    OrderResource orderResource = new OrderResource();

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/orders/{order_id}")
    public Orders greeting(@PathVariable Long order_id) {
        Orders order = orderResource.get(order_id);
        return order;
    }
}
