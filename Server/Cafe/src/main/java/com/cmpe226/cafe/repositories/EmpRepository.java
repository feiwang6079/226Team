package com.cmpe226.cafe.repositories;

import com.cmpe226.cafe.models.Drink;
import com.cmpe226.cafe.models.EmpOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepository extends JpaRepository<EmpOrder, String> {

    @Query(value = "select * from emp_order where emp_id = ?1", nativeQuery = true)
    public List<EmpOrder> getEmpOrder(String emp_id);

}
