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

import com.example.canteen.model.Ord;
import com.example.canteen.service.order_service;

@RestController
@RequestMapping("/orders")
public class order_controller {

    @Autowired
    private order_service orderService;

    // Place a new order
    @PostMapping
    public ResponseEntity<Ord> placeOrder(@RequestBody Ord od) {
        Ord placedOrder = orderService.placeOrder(od);
        return new ResponseEntity<>(placedOrder, HttpStatus.CREATED);
    }

    // Get order by ID
    @GetMapping("/{id}")
    public ResponseEntity<Ord> getOrderById(@PathVariable int id) {
        Optional<Ord> od = orderService.getOrderById(id);
        return od.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get all orders
    @GetMapping
    public ResponseEntity<List<Ord>> getAllOrders() {
        List<Ord> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // Update order
    @PutMapping("/{id}")
    public ResponseEntity<Ord> updateOrder(@PathVariable int id, @RequestBody Ord updatedOrder) {
        Ord od = orderService.updateOrder(id, updatedOrder);
        return new ResponseEntity<>(od, HttpStatus.OK);
    }

    // Delete order by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
