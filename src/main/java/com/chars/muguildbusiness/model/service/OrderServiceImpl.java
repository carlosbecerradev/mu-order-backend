package com.chars.muguildbusiness.model.service;

import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chars.muguildbusiness.dto.OrderRequest;
import com.chars.muguildbusiness.dto.OrderResponse;
import com.chars.muguildbusiness.model.entity.Item;
import com.chars.muguildbusiness.model.entity.Order;
import com.chars.muguildbusiness.model.entity.Usuario;
import com.chars.muguildbusiness.model.repository.IItemRepository;
import com.chars.muguildbusiness.model.repository.IOrderRepository;
import com.chars.muguildbusiness.model.repository.IUsuarioRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private IOrderRepository orderRepository;
	@Autowired
	private ItemService itemService;
	@Autowired
	private UserService userService;

	@Override
	public void save(OrderRequest orderRequest, String username) {
		Usuario user = userService.findByUsername(username);
		
		Order order = mapToEntity(orderRequest);
		order.setCreated(Instant.now());
		order.setEnabled(true);
		order.setUser(user);
		
		orderRepository.save(order);		
	}
	
	private Order mapToEntity(OrderRequest orderRequest) {
		Order order = new Order();
		order.setItem_level(orderRequest.getItemLevel());
		order.setItem_options(orderRequest.getItemOption());
		order.setItem_type(orderRequest.getItemType());
		order.setObservation(orderRequest.getObservation());
		order.setOrder_id(orderRequest.getId());

		Item item = itemService.findById(orderRequest.getItemId());
		order.setItem(item);
		
		return order;
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
	@Transactional(readOnly = true)
	public List<OrderResponse> findAllByItemName(String itemName) {
		Item item = itemService.findByName(itemName);
		
		return orderRepository.findByItem(item)
				.stream()
				.filter(order -> order.getEnabled())
				.map(this::mapToDto)
				.collect(Collectors.toList());
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
