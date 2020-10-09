package com.chars.muguildbusiness.model.service;

import java.util.List;

import com.chars.muguildbusiness.dto.ItemTypeResponse;

public interface ItemTypeService {
	public List<ItemTypeResponse> findAllByItemId(Long itemId);
}
