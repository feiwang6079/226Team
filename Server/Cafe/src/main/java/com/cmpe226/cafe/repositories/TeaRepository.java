package com.cmpe226.cafe.repositories;
// SJSU CMPE 226 Spring 2019 TEAM1

import com.cmpe226.cafe.models.Tea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeaRepository extends JpaRepository<Tea, String> {
    @Query(value = "select * from tea where tea_name = ?1", nativeQuery = true)
    public Tea findByTea_name(String tea_name);
}
