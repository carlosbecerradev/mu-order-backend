package com.chars.muguildbusiness.model.service;

import java.util.List;

import com.chars.muguildbusiness.dto.ItemResponse;
import com.chars.muguildbusiness.model.entity.Item;

public interface ItemService {
	public Item findById(Long id);
	public List<ItemResponse> findAllByName(String name);
}
