package com.chars.muguildbusiness.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chars.muguildbusiness.dto.ItemCategoryResponse;
import com.chars.muguildbusiness.model.entity.ItemCategory;
import com.chars.muguildbusiness.model.repository.IItemCategoryRepository;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

	@Autowired
	private IItemCategoryRepository itemCategoryRepository;
	
	@Override
	public ItemCategoryResponse findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemCategoryResponse findByItemId(Long itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public ItemCategory findByName(String name) {
		return itemCategoryRepository.findByName(name)
				.orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ItemCategoryResponse> findAll() {
		return itemCategoryRepository.findByEnabledTrue()
				.stream()
				.map(this::mapToDto)
				.collect(Collectors.toList());
	}
	
	private ItemCategoryResponse mapToDto(ItemCategory itemCategory) {
		ItemCategoryResponse itemCategoryResponse = new ItemCategoryResponse();
		itemCategoryResponse.setId(itemCategory.getItem_category_id());
		itemCategoryResponse.setName(itemCategory.getName());
		
		return itemCategoryResponse;
	}

}
