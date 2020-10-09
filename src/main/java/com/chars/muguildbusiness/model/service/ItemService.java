package com.chars.muguildbusiness.model.service;

import java.util.List;

import com.chars.muguildbusiness.dto.ItemResponse;

public interface ItemService {
	public List<ItemResponse> findAllByName(String name);
}
