package com.example.canteen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.canteen.model.fooditem;
import com.example.canteen.repository.fooditem_repository;

@Service
public class fooditem_service {
	
	@Autowired
    private fooditem_repository foodItemRepository;

    // Add a new food item
    public fooditem addFoodItem(fooditem fi) {
        return foodItemRepository.save(fi);
    }

    // Get food item by ID
    public Optional<fooditem> getFoodItemById(int id) {
        return foodItemRepository.findById((long) id);
    }

    // Get all food items
    public List<fooditem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    // Update food item information
    public fooditem updateFoodItem(int id, fooditem updatedFoodItem) {
        if(foodItemRepository.existsById((long) id)) {
            updatedFoodItem.setId((long)id);
            return foodItemRepository.save(updatedFoodItem);
        } else {
            throw new RuntimeException("Food item not found");
        }
    }

    // Delete a food item by ID
    public void deleteFoodItem(int id) {
        foodItemRepository.deleteById((long) id);
    }

}
