package com.chars.muguildbusiness.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chars.muguildbusiness.dto.ItemResponse;
import com.chars.muguildbusiness.model.entity.Item;
import com.chars.muguildbusiness.model.repository.IItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private IItemRepository itemRepository;

	@Override
	@Transactional(readOnly = true)
	public Item findById(Long id) {
		return itemRepository.findById(id)
				.orElse(null);
	}

	@Override
	public List<ItemResponse> findAllByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Item findByName(String name) {
		return itemRepository.findByName(name)
				.orElse(null);
	}

}
