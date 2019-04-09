package com.cmpe226.cafe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DrinkRepository extends JpaRepository<Drink, Long> {

}
