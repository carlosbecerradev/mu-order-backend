package com.chars.muguildbusiness.dto;

public class OrderRequest {
	private Long Id;
	private String itemOption;
	private String itemType;
	private Byte itemLevel;
	private String observation;
	private Long itemId;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getItemOption() {
		return itemOption;
	}
	public void setItemOption(String itemPption) {
		this.itemOption = itemPption;
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
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	
}
