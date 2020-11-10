package com.chars.muguildbusiness.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.chars.muguildbusiness.dto.OrderResponse;

public interface MyOrderService {
	public Page<OrderResponse> findAll(String username, Pageable pageable);
	public Page<OrderResponse> findAllByItemName(String itemName, String username, Pageable pageable);
	public Page<OrderResponse> findAllByItemCategoryName(String itemCategoryName, String username, Pageable pageable);
}
