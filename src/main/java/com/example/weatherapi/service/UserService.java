package com.example.weatherapi.service;

import com.example.weatherapi.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final Map<Integer, User> userMap = new HashMap<>();

    public void addUser(User user) {
        userMap.put(user.getId(), user);
    }

    public User getUserById(int id) {
        return userMap.get(id);
    }

    public User removeUserById(int id) {
        return userMap.remove(id);
    }

    public User updateUserById(Integer id, User updateUser){
        if (userMap.containsKey(id))
            userMap.put(id,updateUser);
        return updateUser;

    }
    public Map<Integer, User> getAllUsers() {
        return userMap;
    }
}

