package com.chars.muguildbusiness.model.service;

import java.util.List;
import com.chars.muguildbusiness.dto.OrderResponse;

public interface MyOrderService {
	public List<OrderResponse> findAll(String username);
	public List<OrderResponse> findAllByItemName(String itemName, String username);
	public List<OrderResponse> findAllByItemCategoryName(String itemCategoryName, String username);
}
