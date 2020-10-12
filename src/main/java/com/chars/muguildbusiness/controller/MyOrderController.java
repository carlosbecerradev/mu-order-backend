package com.chars.muguildbusiness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chars.muguildbusiness.dto.OrderResponse;
import com.chars.muguildbusiness.model.service.MyOrderService;

import static org.springframework.http.ResponseEntity.status;

@RequestMapping("/api/my-order")
@RestController
public class MyOrderController {

	@Autowired
	private MyOrderService myOrderService;
	
	@GetMapping
	public ResponseEntity<List<OrderResponse>> getAll(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		return status(HttpStatus.OK)
				.body(myOrderService.findAll(username));
	}
	
	@GetMapping("/by-item/{itemName}")
	public ResponseEntity<List<OrderResponse>> getAllByItem(@PathVariable String itemName){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		return status(HttpStatus.OK)
				.body(myOrderService.findAllByItemName(itemName, username));		
	}
	
	@GetMapping("/by-item-category/{itemCategoryName}")
	public ResponseEntity<List<OrderResponse>> getAllByItemCategory(@PathVariable String itemCategoryName){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		return status(HttpStatus.OK)
				.body(myOrderService.findAllByItemCategoryName(itemCategoryName, username));				
	}
}
