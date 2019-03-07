package com.cmpe226.cafe;

import java.util.HashMap;
import java.util.Map;

public class OrderResource {

    private Map<Long, Order> _orders = new HashMap<>();
    private long _nextId = 0;

    public Order get(long id) {
        return _orders.get(id);
    }

    public long create(Order order) {
        order.setOrder_id(_nextId);
        _orders.put(_nextId, order);
        _nextId++;
        return order.getOrder_id();
    }

    public void delete(Long id) {
        _orders.remove(id);
    }

    public void update(Long id, Order order) {
        order.setOrder_id(id);
        _orders.put(id, order);
    }

}
