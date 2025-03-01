package com.example.canteen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.canteen.model.Ord;
import com.example.canteen.repository.order_repository;

@Service
public class order_service {
	
	@Autowired
    private order_repository orderRepository;

    // Place a new order
    public Ord placeOrder(Ord od) {
        return orderRepository.save(od);
    }

    // Get order by ID
    public Optional<Ord> getOrderById(int id) {
        return orderRepository.findById((long) id);
    }

    // Get all orders
    public List<Ord> getAllOrders() {
        return orderRepository.findAll();
    }

    // Update order status or details
    public Ord updateOrder(int id, Ord updatedOrder) {
        if(orderRepository.existsById((long) id)) {
            updatedOrder.setOrderId((long)id);
            return orderRepository.save(updatedOrder);
        } else {
            throw new RuntimeException("order not found");
        }
    }

    // Delete an order by ID
    public void deleteOrder(int id) {
        orderRepository.deleteById((long) id);
    }

}
