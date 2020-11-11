package com.chars.muguildbusiness.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.chars.muguildbusiness.dto.OrderHistoryRequest;
import com.chars.muguildbusiness.dto.OrderHistoryResponse;

public interface OrderHistoryService {
	public void save(OrderHistoryRequest orderHistoryRequest, String username);
	public Page<OrderHistoryResponse> findAll(String username, Pageable pageable);
	public Page<OrderHistoryResponse> findAllByItemCategoryName(String itemCategoryName, String username, Pageable pageable);
	public Page<OrderHistoryResponse> findAllByItemName(String itemName, String username, Pageable pageable);
}
