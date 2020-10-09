package com.chars.muguildbusiness.model.service;

import java.util.List;

import com.chars.muguildbusiness.dto.ItemOptionResponse;

public interface ItemOptionService {
	public List<ItemOptionResponse> findAllByItemId(Long itemId);
}
