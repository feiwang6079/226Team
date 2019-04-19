package com.cmpe226.cafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeaService {
    @Autowired
    private TeaRepository teaRepository;

    public Tea findByTeaName(String tea_name){
        return teaRepository.findByTea_name(tea_name);
    }

}
