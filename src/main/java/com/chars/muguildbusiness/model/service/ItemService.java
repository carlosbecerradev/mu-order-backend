package com.chars.muguildbusiness.model.service;

import java.util.List;

import com.chars.muguildbusiness.dto.ItemOptionsAndTypes;
import com.chars.muguildbusiness.dto.ItemResponse;
import com.chars.muguildbusiness.model.entity.Item;

public interface ItemService {
	public Item findById(Long id);
	public Item findByName(String name);
	
	public List<ItemResponse> findFirstResultsByName(String name);
	
	public ItemOptionsAndTypes findItemOptionsAndTypes(Long id);
}
