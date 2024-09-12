package com.example.weatherapi.controller;

import com.example.weatherapi.model.User;
import com.example.weatherapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok("User added successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public  ResponseEntity<User> updateUserById(@PathVariable Integer id, @RequestBody User updatedUser){

        User user = userService.updateUserById(id,updatedUser);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
        User removedUser = userService.removeUserById(id);
        if (removedUser != null) {
            return ResponseEntity.ok("User removed successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Map<Integer, User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
