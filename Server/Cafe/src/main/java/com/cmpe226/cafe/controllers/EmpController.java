package com.cmpe226.cafe.controllers;

import com.alibaba.fastjson.JSON;
import com.cmpe226.cafe.models.Customer;
import com.cmpe226.cafe.models.EmpOrder;
import com.cmpe226.cafe.models.Message;
import com.cmpe226.cafe.services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    EmpService empService;

    @GetMapping("/emporder")
    public List<EmpOrder> getEmpOrder(@RequestParam String emp_id){
        List<EmpOrder> c =  empService.getEmpOrder(emp_id);
        return c;
    }

}
