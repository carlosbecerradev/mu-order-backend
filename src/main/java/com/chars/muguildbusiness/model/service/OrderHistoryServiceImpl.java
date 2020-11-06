package com.chars.muguildbusiness.model.service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chars.muguildbusiness.dto.ItemResponse;
import com.chars.muguildbusiness.dto.OrderHistoryRequest;
import com.chars.muguildbusiness.dto.OrderHistoryResponse;
import com.chars.muguildbusiness.dto.OrderResponse;
import com.chars.muguildbusiness.dto.UserResponse;
import com.chars.muguildbusiness.model.entity.Item;
import com.chars.muguildbusiness.model.entity.ItemCategory;
import com.chars.muguildbusiness.model.entity.Order;
import com.chars.muguildbusiness.model.entity.OrderHistory;
import com.chars.muguildbusiness.model.entity.Usuario;
import com.chars.muguildbusiness.model.repository.IItemCategoryRepository;
import com.chars.muguildbusiness.model.repository.IItemRepository;
import com.chars.muguildbusiness.model.repository.IOrderHistoryRepository;
import com.chars.muguildbusiness.model.repository.IOrderRepository;
import com.chars.muguildbusiness.model.repository.IUsuarioRepository;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

	@Autowired
	private IOrderHistoryRepository orderHistoryRepositoty;
	@Autowired
	private IUsuarioRepository userRepository;
	@Autowired
	private IOrderRepository orderRepository;
	@Autowired
	private IItemCategoryRepository itemCategoryRepository;
	@Autowired
	private IItemRepository itemRepository;
	
	@Override
	@Transactional
	public void save(OrderHistoryRequest orderHistoryRequest, String username) {
		Usuario user = userRepository.findByUsername(username).orElse(null);
		Order order = orderRepository.findById(orderHistoryRequest.getOrderId()).orElse(null);
		
		if (user == order.getUser()) {
			order = finishOrder(order);
			
			OrderHistory orderHistory = new OrderHistory();
			orderHistory = mapToEntity(orderHistoryRequest, orderHistory);
			orderHistory.setCreated(Instant.now());
			orderHistory.setOrder(order);
			
			orderHistoryRepositoty.save(orderHistory);
		}		
	}
	
	@Transactional(readOnly = false)
	private Order finishOrder(Order order) {
		order.setEnabled(false);
		orderRepository.save(order);
		return order;
	}
	
	private OrderHistory mapToEntity(OrderHistoryRequest orderHistoryRequest, OrderHistory orderHistory) {
		orderHistory.setMate_id(orderHistoryRequest.getMateId());
		orderHistory.setObservation(orderHistoryRequest.getObservation());
		orderHistory.setPrice(orderHistoryRequest.getPrice());
		return orderHistory;
	}

	@Override
	@Transactional(readOnly = true)
	public List<OrderHistoryResponse> findAll(String username) {
		Usuario user = userRepository.findByUsername(username).orElse(null);
		return orderHistoryRepositoty.findByOrderUser(user)
				.stream()
				.map(this::mapToDto)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public List<OrderHistoryResponse> findAllByItemCategoryName(String itemCategoryName, String username) {
		Usuario user = userRepository.findByUsername(username).orElse(null);
		ItemCategory itemCategory = itemCategoryRepository.findByName(itemCategoryName).orElse(null);
		
		return orderHistoryRepositoty.findByOrderItemItemCategoryAndOrderUser(itemCategory, user)
				.stream()
				.map(this::mapToDto)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public List<OrderHistoryResponse> findAllByItemName(String itemName, String username) {
		Usuario user = userRepository.findByUsername(username).orElse(null);
		Item item = itemRepository.findByName(itemName).orElse(null);
		
		return orderHistoryRepositoty.findByOrderItemAndOrderUser(item, user)
				.stream()
				.map(this::mapToDto)
				.collect(Collectors.toList());
	}
	
	private OrderHistoryResponse mapToDto(OrderHistory orderHistory) {
		OrderHistoryResponse orderHistoryResponse = new OrderHistoryResponse();
		
		orderHistoryResponse.setCreatedAt(orderHistory.getCreated());
		orderHistoryResponse.setId(orderHistory.getOrder_history_id());
		orderHistoryResponse.setObservation(orderHistory.getObservation());
		orderHistoryResponse.setOrder(mapToDto(orderHistory.getOrder()));
		orderHistoryResponse.setPrice(orderHistory.getPrice());
		orderHistoryResponse.setUser(mapToDto(orderHistory.getOrder().getUser()));
		
		return orderHistoryResponse;
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
	
	private UserResponse mapToDto(Usuario usuario) {
		UserResponse userResponse = new UserResponse();
		userResponse.setId(usuario.getUser_id());
		userResponse.setNickname(usuario.getNickname());
		return userResponse;
	}

}
