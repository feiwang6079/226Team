package com.cmpe226.cafe;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/orders")
    public Order greeting(
            @RequestParam(value="total_price", defaultValue="10") String total_price,
            @RequestParam(value="status", defaultValue="Preparing") String status) {

        Order order = new Order(
                counter.incrementAndGet(),
                Long.valueOf(total_price),
                status
        );

        return order;
    }
}
