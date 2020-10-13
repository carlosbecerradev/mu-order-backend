package com.chars.muguildbusiness.model.service;

import java.util.List;

import com.chars.muguildbusiness.dto.OrderHistoryRequest;
import com.chars.muguildbusiness.dto.OrderHistoryResponse;

public interface OrderHistoryService {
	public void save(OrderHistoryRequest orderHistoryRequest, String username);
	public List<OrderHistoryResponse> findAll(String username);
	public List<OrderHistoryResponse> findAllByItemCategoryName(String itemCategoryName, String username);
	public List<OrderHistoryResponse> findAllByItemName(String itemName, String username);
}
