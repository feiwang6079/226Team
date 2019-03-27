package com.cmpe226.cafe;

import com.cmpe226.cafe.web.UserRowMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class CustomerController {

    //CustomerResource userResource = new CustomerResource();
    UserRowMapper userRowMapper = new UserRowMapper();
    @GetMapping("/users")
    public Customer users (
            @RequestParam(value="q", defaultValue = "") String request,
            @RequestParam(value="username", defaultValue = "")  String username,
            @RequestParam(value="password", defaultValue = "")  String password
    ) {
        System.out.println("\nRequest received!");
        System.out.println(" username: " + username);
        System.out.println(" password: " + password);

        if (request.equals("login")) {
            System.out.println(" login!");
            //User user = userResource.login(username, password);
            Customer user = userRowMapper.login(username, password);
            return user;
        }
        return null;
    }



}
