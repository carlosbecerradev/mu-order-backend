package com.chars.muguildbusiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chars.muguildbusiness.dto.OrderHistoryRequest;
import com.chars.muguildbusiness.model.service.OrderHistoryService;

import static org.springframework.http.ResponseEntity.status;

import java.security.Principal;

@RequestMapping("/api/order-history")
@RestController
public class OrderHistoryController {

	@Autowired
	private OrderHistoryService orderHistoryService;
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody OrderHistoryRequest orderHistoryRequest, Principal principal){
		String username = principal.getName();
		orderHistoryService.save(orderHistoryRequest, username);
		return status(HttpStatus.OK)
				.body("Order History was created");
	}
	
}
