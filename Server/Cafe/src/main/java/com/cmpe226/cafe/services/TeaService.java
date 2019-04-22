package com.cmpe226.cafe.services;

import com.cmpe226.cafe.models.Tea;
import com.cmpe226.cafe.repositories.TeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeaService {
    @Autowired
    private TeaRepository teaRepository;

    public Tea findByTeaName(String tea_name){
        return teaRepository.findByTea_name(tea_name);
    }

}
