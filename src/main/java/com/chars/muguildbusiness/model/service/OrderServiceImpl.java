package com.chars.muguildbusiness.model.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chars.muguildbusiness.dto.OrderRequest;
import com.chars.muguildbusiness.dto.OrderResponse;
import com.chars.muguildbusiness.model.entity.Order;
import com.chars.muguildbusiness.model.repository.IOrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private IOrderRepository orderRepository;

	@Override
	public void save(OrderRequest order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<OrderResponse> findAll() {	
		return orderRepository.findAll()
				.stream()
				.filter(order -> order.getEnabled())
				.map(this::mapToDto)
				.collect(Collectors.toList());		
	}
	
	private OrderResponse mapToDto(Order order) {
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setId(order.getOrder_id());
		orderResponse.setItemName(order.getItem().getName());
		orderResponse.setCreatedAt(order.getCreated());
		orderResponse.setItemLevel(order.getItem_level());
		orderResponse.setItemOption(order.getItem_options());
		orderResponse.setItemType(order.getItem_type());
		orderResponse.setNickname(order.getUser().getNickname());
		orderResponse.setObservation(order.getObservation());
		
		return orderResponse;
	}

	@Override
	public List<OrderResponse> findAllByItemName(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderResponse> findAllByItemCategoryName(String itemCategoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
