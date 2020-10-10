package com.chars.muguildbusiness.model.service;

import com.chars.muguildbusiness.dto.ItemCategoryResponse;
import com.chars.muguildbusiness.model.entity.ItemCategory;

public interface ItemCategoryService {
	public ItemCategoryResponse findById(Long id);
	public ItemCategoryResponse findByItemId(Long itemId);

	public ItemCategory findByName(String name);
}
