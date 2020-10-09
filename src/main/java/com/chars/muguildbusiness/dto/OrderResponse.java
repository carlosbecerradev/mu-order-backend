package com.chars.muguildbusiness.dto;

import java.time.Instant;

public class OrderResponse {
	private Long id;
	private String itemName;
	private String itemOption;
	private String itemType;
	private Byte itemLevel;
	private String observation;
	private String nickname;
	private Instant createdAt;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Instant getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
	
}
