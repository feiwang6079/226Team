//package com.cmpe226.cafe.web;
//
//import com.cmpe226.cafe.service.OrderService;
//import com.cmpe226.cafe.Orders;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("api/v1")
//public class OrderApp {
//
//
//
//    @Autowired
//    private OrderService orderService;
//
//    /**
//     * 罗列所有
//     * @return
//     */
//    @GetMapping("/orders")
//    public List<Orders> getAll(){
//        return orderService.findAll();
//    }
//
//    /**
//     * 插入一个记录
//     *
//     * @param total_price
//     * @param status
//     * @return
//     */
//    @PostMapping("/orders")
//    public Orders post(
//                       @RequestParam double total_price,
//                       @RequestParam String status){
//        Orders orders = new Orders(total_price, status);
//
//        return orderService.save(orders);
//    }
//
//    /**
//     * 更新一个记录
//     * @param order_id
//     * @param total_price
//     * @param status
//     * @return
//     */
//    @PutMapping("/orders")
//    public Orders put(@RequestParam long order_id,
//                      @RequestParam double total_price,
//                      @RequestParam String status){
//        Orders orders = new Orders(order_id, total_price, status);
//        return orderService.save(orders);
//    }
//
//    /**
//     * 查找一个
//     * @param id
//     * @return
//     */
//    @GetMapping("/orders/{id}")
//    public Optional<Orders> getOne(@PathVariable long id){
//        return orderService.getOne(id);
//    }
//
//    /**
//     * 删除一个
//     * @param id
//     */
//    @DeleteMapping("/orders/{id}")
//    public void deleteOne(@PathVariable long id){
//        orderService.delete(id);
//    }
//
//
//
//
//}
//
