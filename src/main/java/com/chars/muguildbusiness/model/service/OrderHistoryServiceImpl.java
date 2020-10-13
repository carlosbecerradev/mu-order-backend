package com.chars.muguildbusiness.model.service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chars.muguildbusiness.dto.OrderHistoryRequest;
import com.chars.muguildbusiness.dto.OrderHistoryResponse;
import com.chars.muguildbusiness.model.entity.Item;
import com.chars.muguildbusiness.model.entity.ItemCategory;
import com.chars.muguildbusiness.model.entity.Order;
import com.chars.muguildbusiness.model.entity.OrderHistory;
import com.chars.muguildbusiness.model.entity.Usuario;
import com.chars.muguildbusiness.model.repository.IItemCategoryRepository;
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
	
	@Override
	@Transactional
	public void save(OrderHistoryRequest orderHistoryRequest, String username) {
		Usuario user = userRepository.findByUsername(username).orElse(null);
		Order order = orderRepository.findById(orderHistoryRequest.getOrderId()).orElse(null);
		
		if (user == order.getUser()) {
			OrderHistory orderHistory = new OrderHistory();
			orderHistory = mapToEntity(orderHistoryRequest, orderHistory);
			orderHistory.setCreated(Instant.now());
			orderHistory.setOrder(order);
			
			orderHistoryRepositoty.save(orderHistory);
		}		
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
	
	private OrderHistoryResponse mapToDto(OrderHistory orderHistory) {
		OrderHistoryResponse orderHistoryResponse = new OrderHistoryResponse();
		
		orderHistoryResponse.setCreatedAt(orderHistory.getCreated());
		orderHistoryResponse.setId(orderHistory.getOrder_history_id());
		
		Order order = orderHistory.getOrder();
		orderHistoryResponse.setItemLevel(order.getItem_level());
		orderHistoryResponse.setItemOption(order.getItem_options());
		orderHistoryResponse.setItemType(order.getItem_type());
		
		Item item = orderHistory.getOrder().getItem();
		orderHistoryResponse.setItemName(item.getName());
		
		Usuario mate = userRepository.findById(orderHistory.getMate_id()).orElse(null);
		orderHistoryResponse.setMateNickname(mate.getNickname());
		orderHistoryResponse.setObservation(orderHistory.getObservation());
		orderHistoryResponse.setPrice(orderHistory.getPrice());
		
		return orderHistoryResponse;
	}

}
