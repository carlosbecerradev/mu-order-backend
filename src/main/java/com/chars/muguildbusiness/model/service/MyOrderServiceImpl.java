package com.chars.muguildbusiness.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chars.muguildbusiness.dto.OrderResponse;
import com.chars.muguildbusiness.model.entity.Item;
import com.chars.muguildbusiness.model.entity.ItemCategory;
import com.chars.muguildbusiness.model.entity.Order;
import com.chars.muguildbusiness.model.entity.Usuario;
import com.chars.muguildbusiness.model.repository.IOrderRepository;

@Service
public class MyOrderServiceImpl implements MyOrderService {
	
	@Autowired
	private IOrderRepository orderRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private ItemCategoryService itemCategoryService;

	@Override
	@Transactional(readOnly = true)
	public List<OrderResponse> findAll(String username) {
		Usuario user = userService.findByUsername(username);
		
		return orderRepository.findByEnabledTrueAndUser(user)
				.stream()
				.map(this::mapToDto)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public List<OrderResponse> findAllByItemName(String itemName, String username) {
		Usuario user = userService.findByUsername(username);
		Item item = itemService.findByName(itemName);
				
		return orderRepository.findByEnabledTrueAndUserAndItem(user, item)
				.stream()
				.map(this::mapToDto)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public List<OrderResponse> findAllByItemCategoryName(String itemCategoryName, String username) {
		Usuario user = userService.findByUsername(username);
		ItemCategory itemCategory = itemCategoryService.findByName(itemCategoryName);
		
		return orderRepository.findByEnabledTrueAndUserAndItemItemCategory(user, itemCategory)
				.stream()
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

}
