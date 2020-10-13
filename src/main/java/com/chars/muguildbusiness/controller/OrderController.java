package com.chars.muguildbusiness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<List<OrderResponse>> getAll(){
		return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/by-item/{itemName}")
	public ResponseEntity<List<OrderResponse>> getAllByItem(@PathVariable String itemName){
		return new ResponseEntity<>(orderService.findAllByItemName(itemName), HttpStatus.OK);		
	}
	
	@GetMapping("/by-item-category/{itemCategoryName}")
	public ResponseEntity<List<OrderResponse>> getAllByItemCategory(@PathVariable String itemCategoryName){
		return new ResponseEntity<>(orderService.findAllByItemCategoryName(itemCategoryName), HttpStatus.OK);				
	}
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody OrderRequest order){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		orderService.save(order, auth.getName());
		return new ResponseEntity<>("Order was created", HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id){
		return new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
	}
		
	@PutMapping
	public ResponseEntity<String> edit(@RequestBody OrderRequest order){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		orderService.edit(order, auth.getName());
		return new ResponseEntity<>("Order was edited", HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		orderService.delete(id, auth.getName());
		return new ResponseEntity<>("Order was deleted", HttpStatus.OK);
	}
	
}
