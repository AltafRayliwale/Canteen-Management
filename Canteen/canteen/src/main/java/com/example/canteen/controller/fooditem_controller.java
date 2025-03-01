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

import com.example.canteen.model.fooditem;
import com.example.canteen.service.fooditem_service;

@RestController
@RequestMapping("/fooditems")
public class fooditem_controller {

    @Autowired
    private fooditem_service foodItemService;

    // Add a new food item
    @PostMapping
    public ResponseEntity<fooditem> addFoodItem(@RequestBody fooditem foo) {
        fooditem addedFoodItem = foodItemService.addFoodItem(foo);
        return new ResponseEntity<>(addedFoodItem, HttpStatus.CREATED);
    }

    // Get food item by ID
    @GetMapping("/{id}")
    public ResponseEntity<fooditem> getFoodItemById(@PathVariable int id) {
        Optional<fooditem> foo = foodItemService.getFoodItemById(id);
        return foo.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get all food items
    @GetMapping
    public ResponseEntity<List<fooditem>> getAllFoodItems() {
        List<fooditem> foodItems = foodItemService.getAllFoodItems();
        return new ResponseEntity<>(foodItems, HttpStatus.OK);
    }

    // Update food item
    @PutMapping("/{id}")
    public ResponseEntity<fooditem> updateFoodItem(@PathVariable int id, @RequestBody fooditem updatedFoodItem) {
        fooditem foo = foodItemService.updateFoodItem(id, updatedFoodItem);
        return new ResponseEntity<>(foo, HttpStatus.OK);
    }

    // Delete food item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoodItem(@PathVariable int id) {
        foodItemService.deleteFoodItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}