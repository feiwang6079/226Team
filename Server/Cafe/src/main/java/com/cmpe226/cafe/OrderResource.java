package com.cmpe226.cafe;

import java.util.HashMap;
import java.util.Map;

public class OrderResource {

    private Map<Long, Orders> orders = new HashMap<>();
    private long nextId = 0;

    public OrderResource(){
        // generating 3 fake order
        Orders order;
        long order_id;

        order = new Orders(
                5,
                "Preparing"
        );
        order_id = create(order);
        order.setOrder_id(order_id);

        order = new Orders(
                12,
                "Ready"
        );
        order_id = create(order);
        order.setOrder_id(order_id);

        order = new Orders(
                8,
                "Paid"
        );
        order_id = create(order);
        order.setOrder_id(order_id);
    }

    public Orders get(long id) {
        return orders.get(id);
    }

    public long create(Orders order) {
        order.setOrder_id(nextId);
        orders.put(nextId, order);
        nextId++;
        return order.getOrder_id();
    }

    public void delete(Long id) {
        orders.remove(id);
    }

    public void update(Long id, Orders order) {
        order.setOrder_id(id);
        orders.put(id, order);
    }

}




