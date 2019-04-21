package com.cmpe226.cafe.repositories;

import com.cmpe226.cafe.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Modifying
    @Query(value = "update orders set status = 'paid' where order_id = ?1", nativeQuery = true)
    public int pay(long order_id);


    @Query(value = "select * from orders where cus_id = ?1", nativeQuery = true)
    public List<Orders> reviewMyOrders(long cus_id);


}
