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

import com.example.canteen.model.admin;
import com.example.canteen.service.admin_service;

@RestController
@RequestMapping("/admins")
public class admin_controller {

    @Autowired
    private admin_service adminService;

    // Register a new admin
    @PostMapping("/register")
    public ResponseEntity<admin> registerAdmin(@RequestBody admin ad) {
        admin registeredAdmin = adminService.registerAdmin(ad);
        return new ResponseEntity<>(registeredAdmin, HttpStatus.CREATED);
    }

    // Get admin by ID
    @GetMapping("/{id}")
    public ResponseEntity<admin> getAdminById(@PathVariable int id) {
        Optional<admin> ad = adminService.getAdminById(id);
        return ad.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get all admins
    @GetMapping
    public ResponseEntity<List<admin>> getAllAdmins() {
        List<admin> admins = adminService.getAllAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    // Update admin information
    @PutMapping("/{id}")
    public ResponseEntity<admin> updateAdmin(@PathVariable int id, @RequestBody admin updatedAdmin) {
        admin ad = adminService.updateAdmin(id, updatedAdmin);
        return new ResponseEntity<>(ad, HttpStatus.OK);
    }

    // Delete admin by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable int id) {
        adminService.deleteAdmin(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
