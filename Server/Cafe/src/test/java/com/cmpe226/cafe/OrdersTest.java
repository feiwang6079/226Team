package com.cmpe226.cafe;

import com.cmpe226.cafe.models.Drink;
import com.cmpe226.cafe.models.Orders;
import com.cmpe226.cafe.services.TeaService;
import com.cmpe226.cafe.services.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdersTest {
    @Autowired
    private OrderService orderService;
    @Autowired
    private TeaService teaService;
    @Test
    public void saveOrder(){

        Orders orders = new Orders();
        orders.setCus_id(1203456789);
        orders.setRe_id("cafe_01");

        List<Drink> drinks = new ArrayList<>();
        Drink d1 = new Drink( "50%",  "30%",
        23, "emp_01", "Tieguanyin", "boba");
        d1.setOrders(orders);
        drinks.add(d1);

        Drink d2 = new Drink( "0%",  "0%",
                23, "emp_01", "Tieguanyin", "boba");
        d2.setOrders(orders);
        drinks.add(d2);

        orders.setDrinks(drinks);
        double total_price = 0;
        for(Drink d: drinks) {
            total_price += teaService.findByTeaName(d.getTea_name()).getPrice();
        }
        orders.setTotal_price(total_price);
        orderService.save(orders);
    }

    public void pay(){
        orderService.pay(4);
    }

}
