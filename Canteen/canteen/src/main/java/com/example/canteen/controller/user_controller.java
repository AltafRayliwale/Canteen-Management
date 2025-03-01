package com.example.canteen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.canteen.model.user;
import com.example.canteen.service.user_service;

@RestController
@RequestMapping("/users")
public class user_controller {

	@Autowired
    private user_service userService;

    // Register a new user
    @PostMapping("/register")
    public ResponseEntity<user> registerUser(@RequestBody user us) {
        user registeredUser = userService.registerUser(us);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<user> getUserById(@PathVariable int id) {
        Optional<user> us = userService.getUserById(id);
        return us.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<user>> getAllUsers() {
        List<user> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Update user information
    @PutMapping("/{id}")
    public ResponseEntity<user> updateUser(@PathVariable int id, @RequestBody user updatedUser) {
        user us = userService.updateUser(id, updatedUser);
        return new ResponseEntity<>(us, HttpStatus.OK);
    }

    // Delete user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
