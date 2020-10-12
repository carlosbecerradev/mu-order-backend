package com.chars.muguildbusiness.model.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chars.muguildbusiness.dto.OrderHistoryRequest;
import com.chars.muguildbusiness.model.entity.Order;
import com.chars.muguildbusiness.model.entity.OrderHistory;
import com.chars.muguildbusiness.model.entity.Usuario;
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

}
