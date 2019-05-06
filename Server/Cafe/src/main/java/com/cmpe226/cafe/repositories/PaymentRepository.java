// SJSU CMPE 226 Spring 2019 TEAM1
package com.cmpe226.cafe.repositories;

import com.cmpe226.cafe.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
