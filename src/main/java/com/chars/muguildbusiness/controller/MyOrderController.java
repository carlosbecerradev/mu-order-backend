package com.chars.muguildbusiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chars.muguildbusiness.dto.OrderResponse;
import com.chars.muguildbusiness.model.service.MyOrderService;

import static org.springframework.http.ResponseEntity.status;

@RequestMapping("/api/my-order")
@RestController
public class MyOrderController {
	
	@Value("${pagination.pageSize}")
	private Byte pageSize;

	@Autowired
	private MyOrderService myOrderService;
	
	@GetMapping
	public ResponseEntity<Page<OrderResponse>> getAll(
			@RequestParam(name = "page", defaultValue = "0", required = false) int page){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		PageRequest pageReques = PageRequest.of(page, pageSize);
				
		return status(HttpStatus.OK)
				.body(myOrderService.findAll(username, pageReques));
	}
	
	@GetMapping("/by-item/{itemName}")
	public ResponseEntity<Page<OrderResponse>> getAllByItem(
			@PathVariable String itemName, 
			@RequestParam(name = "page", defaultValue = "0", required = false) int page){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		PageRequest pageReques = PageRequest.of(page, pageSize);
		
		return status(HttpStatus.OK)
				.body(myOrderService.findAllByItemName(itemName, username, pageReques));		
	}
	
	@GetMapping("/by-item-category/{itemCategoryName}")
	public ResponseEntity<Page<OrderResponse>> getAllByItemCategory(
			@PathVariable String itemCategoryName, 
			@RequestParam(name = "page", defaultValue = "0", required = false) int page){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		PageRequest pageReques = PageRequest.of(page, pageSize);
		
		return status(HttpStatus.OK)
				.body(myOrderService.findAllByItemCategoryName(itemCategoryName, username, pageReques));				
	}
}
