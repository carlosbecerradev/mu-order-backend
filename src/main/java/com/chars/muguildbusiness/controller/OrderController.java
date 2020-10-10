package com.chars.muguildbusiness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chars.muguildbusiness.dto.OrderRequest;
import com.chars.muguildbusiness.dto.OrderResponse;
import com.chars.muguildbusiness.model.service.OrderService;

@RequestMapping("/api/order")
@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@GetMapping
	public ResponseEntity<List<OrderResponse>> get(){
		return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody OrderRequest order){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		orderService.save(order, auth.getName());
		return new ResponseEntity<>("Order was created", HttpStatus.CREATED);
	}
	
	@GetMapping("/{itenName}")
	public ResponseEntity<List<OrderResponse>> getAllByItemName(@PathVariable String itenName){
		return new ResponseEntity<>(orderService.findAllByItemName(itenName), HttpStatus.OK);
	}
}
