package com.chars.muguildbusiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chars.muguildbusiness.dto.OrderHistoryRequest;
import com.chars.muguildbusiness.dto.OrderHistoryResponse;
import com.chars.muguildbusiness.model.service.OrderHistoryService;

import static org.springframework.http.ResponseEntity.status;

import java.security.Principal;

@RequestMapping("/api/order-history")
@RestController
public class OrderHistoryController {
	
	@Value("${pagination.pageSize}")
	private Byte pageSize;

	@Autowired
	private OrderHistoryService orderHistoryService;
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody OrderHistoryRequest orderHistoryRequest, Principal principal){
		String username = principal.getName();
		orderHistoryService.save(orderHistoryRequest, username);
		return status(HttpStatus.CREATED)
				.body("Order History was created");
	}
	
	@GetMapping
	public ResponseEntity<Page<OrderHistoryResponse>> getAll(Principal principal, 
			@RequestParam(name = "page", defaultValue = "0", required = false) int page){
		String username = principal.getName();
		PageRequest pageRequest = PageRequest.of(page, pageSize);
		return status(HttpStatus.OK)
				.body(orderHistoryService.findAll(username, pageRequest));
	}
	
	@GetMapping("/by-item-category/{itemCategoryName}")
	public ResponseEntity<Page<OrderHistoryResponse>> getAllByItemCategory(@PathVariable String itemCategoryName, Principal principal, 
			@RequestParam(name = "page", defaultValue = "0", required = false) int page){
		String username = principal.getName();
		PageRequest pageRequest = PageRequest.of(page, pageSize);
		return status(HttpStatus.OK)
				.body(orderHistoryService.findAllByItemCategoryName(itemCategoryName, username, pageRequest));
	}
	
	@GetMapping("/by-item/{itemName}")
	public ResponseEntity<Page<OrderHistoryResponse>> getAllByItem(@PathVariable String itemName, Principal principal, 
			@RequestParam(name = "page", defaultValue = "0", required = false) int page){
		String username = principal.getName();
		PageRequest pageRequest = PageRequest.of(page, pageSize);
		return status(HttpStatus.OK)
				.body(orderHistoryService.findAllByItemName(itemName, username, pageRequest));
	}
}
