package com.chars.muguildbusiness.model.service;

import com.chars.muguildbusiness.dto.OrderHistoryRequest;

public interface OrderHistoryService {
	public void save(OrderHistoryRequest orderHistoryRequest, String username);
}
