package com.cmpe226.cafe.services;

import com.cmpe226.cafe.models.EmpOrder;
import com.cmpe226.cafe.repositories.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    EmpRepository empRepository;

    public List<EmpOrder> getEmpOrder(String emp_id){
        return empRepository.getEmpOrder(emp_id);
    }
}
