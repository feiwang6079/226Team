//package com.cmpe226.cafe;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class OrderResource {
//
//    private Map<Long, Orders> orders = new HashMap<>();
//    private long nextId = 0;
//
//    public OrderResource(){
//
//    }
//
//    public Orders get(long id) {
//
//        return orders.get(id);
//    }
//
//    public long create(Orders order) {
//        order.setOrder_id(nextId);
//        orders.put(nextId, order);
//        nextId++;
//        return order.getOrder_id();
//    }
//
//    public void delete(Long id) {
//        orders.remove(id);
//    }
//
//    public void update(Long id, Orders order) {
//        order.setOrder_id(id);
//        orders.put(id, order);
//    }
//
//}
//
//
//
//
