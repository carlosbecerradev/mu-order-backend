package com.chars.muguildbusiness.dto;

import java.time.Instant;

public class OrderHistoryResponse {
	private Long id;
	private String mateNickname;
	private String price;
	private String observation;
	private Instant createdAt;
	
	private String itemName;
	private String itemOption;
	private String itemType;
	private Byte itemLevel;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMateNickname() {
		return mateNickname;
	}
	public void setMateNickname(String mateNickname) {
		this.mateNickname = mateNickname;
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
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemOption() {
		return itemOption;
	}
	public void setItemOption(String itemOption) {
		this.itemOption = itemOption;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public Byte getItemLevel() {
		return itemLevel;
	}
	public void setItemLevel(Byte itemLevel) {
		this.itemLevel = itemLevel;
	}
	
}
