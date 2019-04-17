package com.cmpe226.cafe;

//import UserRowMapper;
import com.cmpe226.cafe.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

//    CustomerResource customerResource = new CustomerResource();

    @Autowired
    CustomerService customerService;

////   @Autowired
////    UserRowMapper userRowMapper;
    @Autowired
    CustomerResource customerResource;
//    @GetMapping("/users")
//    public Customer users (
//            @RequestParam(value="q", defaultValue = "") String request,
//            @RequestParam(value="username", defaultValue = "")  String username,
//            @RequestParam(value="password", defaultValue = "")  String password
//    ) {
//        System.out.println("\nRequest received!");
//        System.out.println(" username: " + username);
//        System.out.println(" password: " + password);
//
//        if (request.equals("login")) {
//            System.out.println(" login!");
//            //User user = userResource.login(username, password);
//            Customer user = customerResource.get(username);
//            return user;
//        }
//        return null;
//    }
//
    @GetMapping("/cusTest")
    public Customer customer(@RequestParam String id){
        System.out.println("cusTest is started");
        Customer customer = customerResource.get(id);
        return  customer;
    }

    @PostMapping("/payByBalance")
    public int payByBalance(@RequestParam String cus_id,
                               @RequestParam double total_price){

       return customerService.payByBalance(cus_id,total_price);
    }

    @PostMapping("/topUp")
    public int topUp(@RequestParam String cus_id,
                     @RequestParam double value){

        return customerService.topUp(cus_id, value);
    }

    @GetMapping("/review")
    public Customer review(@RequestParam String cus_id){
        return customerService.review(cus_id);
    }

    @GetMapping("/user")
    public Message review(@RequestParam String cus_id, @RequestParam String password){
        Customer c =  customerService.review(cus_id);
        if(c != null && c.getPassword().equals(password)) {
            return new Message(200, "Success", c.toString());
        }else {
            return new Message(401, "Wrong password", "");
        }
    }

    @PostMapping("/saveCustomer")
    public Customer saveCustomer(//@RequestParam long cus_id,
                                 @RequestParam String password,
                                 @RequestParam double points,
                                 @RequestParam double account_balance){
        Customer c = new Customer();
        c.setPoints( points);
        c.setPassword(password);
        c.setAccount_balance(account_balance);
        return customerService.saveCustomer(c);
    }

}
