package com.cmpe226.cafe.web;

import com.cmpe226.cafe.Orders;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Modifying
    @Query(value = "update orders set status = 'paid' where order_id = ?1", nativeQuery = true)
    public int pay(long order_id);


    @Query(value = "select * from orders where cus_id = ?1", nativeQuery = true)
    public List<Orders> reviewMyOrders(long cus_id);



}
