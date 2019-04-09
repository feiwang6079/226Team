package com.cmpe226.cafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinkService {
    @Autowired
    DrinkRepository drinkRepository;


    public Drink save(Drink drink) {
        return drinkRepository.save(drink);
    }
}
