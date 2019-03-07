package com.cmpe226.cafe;

import org.springframework.web.bind.annotation.*;

/**
 * Get order: curl -X GET 'http://localhost:8080/orders?q=get&order_id=0'
 * Create order: curl -X GET 'http://localhost:8080/orders?q=post&total_price=3&status=pending'
 * Update order: curl -X GET 'http://localhost:8080/orders?q=update&order_id=0&total_price=100&status=paid'
 * Delete order: curl -X GET 'http://localhost:8080/orders?q=delete&order_id=1'
 */

@RestController
public class OrderController {

    OrderResource orderResource = new OrderResource();

    @GetMapping("/orders")
    public Order orders(
            @RequestParam(value="q", defaultValue = "") String request,
            @RequestParam(value="order_id", defaultValue = "")  Long order_id,
            @RequestParam(value="total_price", defaultValue = "")  Long total_price,
            @RequestParam(value="status", defaultValue = "")  String status
    ) {
        System.out.println("\nRequest received!");
        System.out.println(" request: " + request);
        System.out.println(" order_id: " + order_id);
        System.out.println(" total_price: " + total_price);
        System.out.println(" status: " + status);

        if (request.equals("get")) {
            // Get an order
            Order order = orderResource.get(order_id);
            return order;
        } else if (request.equals("post")){
            // Create a post
            Order order = new Order(total_price, status);
            order_id = orderResource.create(order);
            order.setOrder_id(order_id);
            return order;
        } else if (request.equals("update")) {
            // Update an order
            Order order = orderResource.get(order_id);
            if (total_price != null) {
                order.setTotal_price(total_price);
            }
            if (status != null && !status.equals("")) {
                order.setStatus(status);
            }
            return order;
        } else if (request.equals("delete")) {
            // Delete an order
            orderResource.delete(order_id);
        }

        return null;
    }
}
