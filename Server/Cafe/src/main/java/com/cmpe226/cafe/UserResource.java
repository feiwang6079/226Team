package com.cmpe226.cafe;

import java.util.HashMap;
import java.util.Map;

public class UserResource {

    private Map<String, User> users = new HashMap<>();
    private long nextId = 0;

    public UserResource(){
        // generating 3 fake order
        User user;

        user = new User(
                "user1",
                "pass1"
        );
        create(user);

        user = new User(
                "cat",
                "dog"
        );
        create(user);

        user = new User(
                "milaoshu",
                "tanglaoya"
        );
        create(user);
    }

    public void create(User user) {
        users.put(user.getCus_id(), user);
    }

    public User get(String id) {
        return users.get(id);
    }

    public void delete(String id) {
        users.remove(id);
    }

    public void update(String id, User user) {
        users.put(id, user);
    }

    public User login(String id, String password) {
        User user = users.get(id);
        if (user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
