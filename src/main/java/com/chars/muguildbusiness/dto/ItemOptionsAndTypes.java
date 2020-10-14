package com.chars.muguildbusiness.dto;

import java.util.List;

public class ItemOptionsAndTypes {
	private List<ItemOptionResponse> itemOptionsResponse;
	private List<ItemTypeResponse> itemTypesResponse;
	
	public List<ItemOptionResponse> getItemOptions() {
		return itemOptionsResponse;
	}
	public void setItemOptionsResponse(List<ItemOptionResponse> itemOptionResponse) {
		this.itemOptionsResponse = itemOptionResponse;
	}
	public List<ItemTypeResponse> getItemTypes() {
		return itemTypesResponse;
	}
	public void setItemTypesResponse(List<ItemTypeResponse> itemTypesResponse) {
		this.itemTypesResponse = itemTypesResponse;
	}
	
}
