package com.chars.muguildbusiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chars.muguildbusiness.dto.ItemCategoryResponse;
import com.chars.muguildbusiness.model.service.ItemCategoryService;

import static org.springframework.http.ResponseEntity.status;

import java.util.List;

@RequestMapping("/api/item-category")
@RestController
public class ItemCategoryController {
	
	@Autowired
	private ItemCategoryService itemCategoryService;

	@GetMapping
	public ResponseEntity<List<ItemCategoryResponse>> getAll(){
		return status(HttpStatus.OK)
				.body(itemCategoryService.findAll());
	}
	
}
