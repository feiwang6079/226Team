package com.cmpe226.cafe.repositories;

import com.cmpe226.cafe.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.List;
import java.util.Timer;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    @Transactional
    @Modifying
    @Query(value = "update orders set status = 'paid' where order_id = ?1", nativeQuery = true)
    public int pay(long order_id);


    @Query(value = "select * from orders where cus_id = ?1 order by order_id desc", nativeQuery = true)
    public List<Orders> reviewMyOrders(long cus_id);


    @Query(value = "select * from orders where order_id = ?1", nativeQuery = true)
    public Orders getOrder(long order_id);

    @Transactional
    @Modifying
    @Query(value = "insert into orders(order_id, total_price, status, t, cus_id, re_id) values(?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    public int insertOrders(long order_id, double price, String status, Time t, double cus_id, String re_id);

    @Query(value = "select count(*) from orders", nativeQuery = true)
    public long getOrderCount();
}
