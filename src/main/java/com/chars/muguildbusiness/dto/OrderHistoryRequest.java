package com.chars.muguildbusiness.dto;

public class OrderHistoryRequest {
	private Long mateId;
	private String price;
	private String observation;
	private Long orderId;
	
	public Long getMateId() {
		return mateId;
	}
	public void setMateId(Long mateId) {
		this.mateId = mateId;
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
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
}