package com.chars.muguildbusiness.model.service;

import java.util.List;

import com.chars.muguildbusiness.dto.ItemCategoryResponse;
import com.chars.muguildbusiness.model.entity.ItemCategory;

public interface ItemCategoryService {
	public List<ItemCategoryResponse> findAll();

	public ItemCategory findByName(String name);
}
