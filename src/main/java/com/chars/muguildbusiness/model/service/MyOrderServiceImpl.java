package com.chars.muguildbusiness.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chars.muguildbusiness.dto.ItemResponse;
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
	public Page<OrderResponse> findAll(String username, Pageable pageable) {
		Usuario user = userService.findByUsername(username);
		
		return orderRepository.findByEnabledTrueAndUserOrderByCreatedDesc(user, pageable)
				.map(this::mapToDto);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<OrderResponse> findAllByItemName(String itemName, String username, Pageable pageable) {
		Usuario user = userService.findByUsername(username);
		Item item = itemService.findByName(itemName);
				
		return orderRepository.findByEnabledTrueAndUserAndItemOrderByCreatedDesc(user, item, pageable)
				.map(this::mapToDto);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<OrderResponse> findAllByItemCategoryName(String itemCategoryName, String username, Pageable pageable) {
		Usuario user = userService.findByUsername(username);
		ItemCategory itemCategory = itemCategoryService.findByName(itemCategoryName);
		
		return orderRepository.findByEnabledTrueAndUserAndItemItemCategoryOrderByCreatedDesc(user, itemCategory, pageable)
				.map(this::mapToDto);
	}
	
	private OrderResponse mapToDto(Order order) {
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setId(order.getOrder_id());
		orderResponse.setItem(mapToDto(order.getItem()));
		orderResponse.setCreatedAt(order.getCreated());
		orderResponse.setItemLevel(order.getItem_level());
		orderResponse.setItemOption(order.getItem_options());
		orderResponse.setItemType(order.getItem_type());
		orderResponse.setNickname(order.getUser().getNickname());
		orderResponse.setObservation(order.getObservation());
		
		return orderResponse;
	}
	
	private ItemResponse mapToDto(Item item) {
		ItemResponse itemResponse = new ItemResponse();
		itemResponse.setId(item.getItem_id());
		itemResponse.setName(item.getName());
		
		return itemResponse;
	}

}
