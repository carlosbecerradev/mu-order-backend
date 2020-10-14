package com.chars.muguildbusiness.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chars.muguildbusiness.dto.ItemResponse;
import com.chars.muguildbusiness.model.entity.Item;
import com.chars.muguildbusiness.model.repository.IItemRepository;

import org.springframework.data.domain.PageRequest;

@Service
public class ItemServiceImpl implements ItemService {
	
	private final Byte FIRST_RESULTS = 5;
	
	@Autowired
	private IItemRepository itemRepository;

	@Override
	@Transactional(readOnly = true)
	public Item findById(Long id) {
		return itemRepository.findById(id)
				.orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Item findByName(String name) {
		return itemRepository.findByName(name)
				.orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ItemResponse> findFirstResultsByName(String name) {
		return itemRepository.findByNameIgnoreCaseContaining(name, PageRequest.of(0, FIRST_RESULTS))
				.stream()
				.map(this::mapToDto)
				.collect(Collectors.toList());
	}
	
	private ItemResponse mapToDto(Item item) {
		ItemResponse itemResponse = new ItemResponse();
		itemResponse.setItem_id(item.getItem_id());
		itemResponse.setName(item.getName());
		
		return itemResponse;
	}

}
