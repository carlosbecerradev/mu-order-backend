package com.chars.muguildbusiness.model.service;

import com.chars.muguildbusiness.dto.ItemCategoryResponse;

public interface ItemCategoryService {
	public ItemCategoryResponse findById(Long id);
	public ItemCategoryResponse findByItemId(Long itemId);
}
