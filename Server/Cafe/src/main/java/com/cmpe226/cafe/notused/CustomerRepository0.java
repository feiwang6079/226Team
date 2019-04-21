//package com.cmpe226.cafe.web;
//
//import com.cmpe226.cafe.models.Customer;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import javax.transaction.Transactional;
//
//@Repository
//public interface CustomerRepository0 extends JpaRepository<Customer, String> {
//    @Transactional
//    @Modifying
//    @Query("update customer set balance = balance - ?2 where cus_id = ?1")
//    public String payByBanlance(String cus_id, double total_price);
//    @Transactional
//    @Modifying
//    @Query("update customer set balance = balance + ?2 where cus_id = ?1")
//    public String topUp(String cus_id, double value);
//
////    @Query(value = "select * from customer where cus_id = ?1", nativeQuery = true)
////    public Customer review(String cus_id);
//}
