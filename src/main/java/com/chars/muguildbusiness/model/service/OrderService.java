package com.chars.muguildbusiness.model.service;

import java.util.List;

import com.chars.muguildbusiness.dto.OrderRequest;
import com.chars.muguildbusiness.dto.OrderResponse;

public interface OrderService {
	public void save(OrderRequest order);
	public List<OrderResponse> findAll();
	public List<OrderResponse> findAllByItemName(String itemName);
	public List<OrderResponse> findAllByItemCategoryName(String itemCategoryName);
	public void delete(Long id);
}
