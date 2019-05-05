package com.cmpe226.cafe.repositories;

import com.cmpe226.cafe.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//import javax.transaction.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    //PayByBalance
    @Transactional
    @Modifying
    @Query("update Customer c set c.account_balance = c.account_balance - ?2 where cus_id = ?1")
    public int payByBalance(long cus_id, double total_price);

    //topUp
    @Transactional
    @Modifying
    @Query(value = "update customer set account_balance = account_balance + ?2 where cus_id = ?1", nativeQuery = true)
    public int topUp(long cus_id, double value);

    //review
    @Query(value = "select * from customer where cus_id = ?1", nativeQuery = true)
    public Customer review(long cus_id);

    @Query(value = "select account_balance from customer where cus_id = ?1", nativeQuery = true)
    public double getAccountBalance(long cus_id);

    @Procedure(name = "PAY")
    public String payOrder(@Param("my_cus_id") Long cur_cus_id, @Param("my_order_id") Long cur_order_id);
}
