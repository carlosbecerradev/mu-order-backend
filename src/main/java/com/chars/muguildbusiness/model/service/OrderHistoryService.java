package com.chars.muguildbusiness.model.service;

import java.util.List;

import com.chars.muguildbusiness.dto.OrderHistoryRequest;
import com.chars.muguildbusiness.dto.OrderHistoryResponse;

public interface OrderHistoryService {
	public void save(OrderHistoryRequest orderHistory);
	public List<OrderHistoryResponse> findAll(String username);
	public List<OrderHistoryResponse> findAllByItemName(String itemName);
	public List<OrderHistoryResponse> findAllByItemCategoryName(String itemCategoryName);
}
