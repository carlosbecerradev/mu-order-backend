package com.chars.muguildbusiness.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.chars.muguildbusiness.dto.OrderRequest;
import com.chars.muguildbusiness.dto.OrderResponse;

public interface OrderService {
	public OrderResponse findById(Long id);
	public void save(OrderRequest orderRequest, String username);
	public void edit(OrderRequest orderRequest, String username);
	public Page<OrderResponse> findAll(Pageable pageable);
	public Page<OrderResponse> findAllByItemName(String itemName, Pageable pageable);
	public Page<OrderResponse> findAllByItemCategoryName(String itemCategoryName, Pageable pageable);
	public void delete(Long id, String username);
}
