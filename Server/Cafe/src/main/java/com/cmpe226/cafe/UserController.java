package com.cmpe226.cafe;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    UserResource userResource = new UserResource();

    @GetMapping("/users")
    public User users(
            @RequestParam(value="q", defaultValue = "") String request,
            @RequestParam(value="username", defaultValue = "")  String username,
            @RequestParam(value="password", defaultValue = "")  String password
    ) {
        System.out.println("\nRequest received!");
        System.out.println(" username: " + username);
        System.out.println(" password: " + password);

        if (request.equals("login")) {
            System.out.println(" login!");
            User user = userResource.login(username, password);
            return user;
        }
        return null;
    }
}
