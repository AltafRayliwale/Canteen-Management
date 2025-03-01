package com.example.canteen.model;

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Ord")
public class Ord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	
	@Column(name = "user_id")
    private long userId;
    
    @Column(name = "food_id")
    private long foodId;
    
    @Column(name = "quantity")
    private int quantity;
    
    @Column(name = "total_price")
    private double totalPrice;
    
    @Column(name = "order_status", length = 15)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    
    @Column(name = "rating")
    private double rating;
    
    @Column(name = "order_time")
    @CreationTimestamp
    private LocalDateTime orderTime;
    
    @Column(name = "delivery_time")
    @CreationTimestamp
    private LocalDateTime deliveryTime;

    // Getters and setters for each field...
	
	
	    
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getFoodId() {
		return foodId;
	}

	public void setFoodId(long foodId) {
		this.foodId = foodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Date getOrderTime() {
		return getOrderTime();
	}

	public void setOrderTime(Date orderTime) {
		this.setDeliveryTime(orderTime);
	}

	public Date getDeliveryTime() {
		return getDeliveryTime();
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.setDeliveryTime(deliveryTime);
	}

	    public enum OrderStatus {
	        PENDING,
	        PREPARING,
	        COMPLETED,
	        DELIVERED,
	        CANCELED
	    }
	}

