package com.example.canteen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.canteen.model.user;
import com.example.canteen.repository.user_repository;

@Service
public class user_service {
	
	@Autowired
    private user_repository userRepository;

    // Register a new user
    public user registerUser(user u) {
        return userRepository.save(u);
    }

    // Find user by ID
    public Optional<user> getUserById(int id) {
        return userRepository.findById((long) id);
    }

    // Get all users
    public List<user> getAllUsers() {
        return userRepository.findAll();
    }

    // Update user information
    public user updateUser(int id, user updatedUser) {
        if(userRepository.existsById((long) id)) {
            updatedUser.setId((long)id);
            return userRepository.save(updatedUser);
        } else {
            throw new RuntimeException("user not found");
        }
    }

    // Delete a user by ID
    public void deleteUser(int id) {
        userRepository.deleteById((long) id);
    }

}
