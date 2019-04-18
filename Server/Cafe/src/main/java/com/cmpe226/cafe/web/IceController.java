package com.cmpe226.cafe.web;

import com.cmpe226.cafe.Ice;
import com.cmpe226.cafe.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IceController {
    @Autowired
    IceRowMapper iceRowMapper;

    @GetMapping("/listAllIce")
    public Message listAllIce(){

        List<Ice> ices = iceRowMapper.findAllIce();
        String data;
        ObjectMapper mapper = new ObjectMapper();

        try{
            data = mapper.writeValueAsString(ices);
        }catch (Exception e){
            data = "";
        }

        return new Message(200, "Success", data);
    }
}
