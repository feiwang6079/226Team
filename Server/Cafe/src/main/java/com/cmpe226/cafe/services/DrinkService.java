package com.cmpe226.cafe.services;

import com.cmpe226.cafe.repositories.DrinkRepository;
import com.cmpe226.cafe.models.Drink;
import com.cmpe226.cafe.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinkService {
    @Autowired
    DrinkRepository drinkRepository;
    @Autowired
    OrderRepository orderRepository;

    public Drink save(Drink drink){
        return  drinkRepository.save(drink);
    }

    public Drink update(Drink drink){
        return  drinkRepository.save(drink);
    }

//    @Transactional
//        public List<Drink> saveAll(List<Drink> drinks, String res, long cus_id) {
//        Orders o = orderRepository.save(new Orders());
//        double price = 0;
//        for(Drink d : drinks){
//            d.setOrder_id(o.getOrder_id());
//            price += d.getPrice() + d.getTopping().getPrice();
//        }
//        List<Drink> ds = drinkRepository.saveAll(drinks);
//        o.setTotal_price(price);
//        o.setRe_id(res);
//        o.setCus_id(cus_id);
//        o.setDrinks(ds);
//        o = orderRepository.save(o);
//        return ds;
//    }



}
