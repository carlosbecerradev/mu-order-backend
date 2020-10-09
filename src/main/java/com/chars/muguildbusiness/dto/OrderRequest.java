package com.chars.muguildbusiness.dto;

public class OrderRequest {
	private Long Id;
	private String itemPption;
	private String itemType;
	private Byte itemLevel;
	private String observation;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getItemPption() {
		return itemPption;
	}
	public void setItemPption(String itemPption) {
		this.itemPption = itemPption;
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
	
}
