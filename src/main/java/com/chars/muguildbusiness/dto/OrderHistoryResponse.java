package com.chars.muguildbusiness.dto;

import java.time.Instant;

public class OrderHistoryResponse {
	private Long id;
	private UserResponse user;
	private String price;
	private String observation;
	private Instant createdAt;
	
	private OrderResponse order;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserResponse getUser() {
		return user;
	}
	public void setUser(UserResponse user) {
		this.user = user;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public Instant getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
	public OrderResponse getOrder() {
		return order;
	}
	public void setOrder(OrderResponse order) {
		this.order = order;
	}
	
}
