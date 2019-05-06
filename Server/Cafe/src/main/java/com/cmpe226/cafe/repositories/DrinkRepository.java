// SJSU CMPE 226 Spring 2019 TEAM1
package com.cmpe226.cafe.repositories;

import com.cmpe226.cafe.models.Customer;
import com.cmpe226.cafe.models.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public interface DrinkRepository extends JpaRepository<Drink, Long> {

    //review
    @Transactional
    @Modifying
    @Query(value = "insert into drink(ice_level, sugar_level, topping, price, emp_id, tea_name, order_id) " +
            "       values (?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
    public int insertDrink(String ice_level, String sugar_level, String topping, double price,
                               String emp_id, String tea_name, long order_id);

    @Query(value = "select * from drink where order_id = ?1", nativeQuery = true)
    public List<Drink> getDrinks(long orderId);
}
