package com.chars.muguildbusiness.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chars.muguildbusiness.dto.ItemOptionResponse;
import com.chars.muguildbusiness.dto.ItemOptionsAndTypes;
import com.chars.muguildbusiness.dto.ItemResponse;
import com.chars.muguildbusiness.dto.ItemTypeResponse;
import com.chars.muguildbusiness.model.entity.Item;
import com.chars.muguildbusiness.model.entity.ItemCategory;
import com.chars.muguildbusiness.model.entity.ItemCategoryOption;
import com.chars.muguildbusiness.model.entity.ItemCategoryType;
import com.chars.muguildbusiness.model.entity.ItemOption;
import com.chars.muguildbusiness.model.entity.ItemType;
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
		return itemRepository.findByEnabledTrueAndNameIgnoreCaseContaining(name, PageRequest.of(0, FIRST_RESULTS))
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

	@Override
	@Transactional(readOnly = true)
	public ItemOptionsAndTypes findItemOptionsAndTypes(Long id) {
		Item item = findById(id);
		ItemCategory itemCategory = item.getItemCategory();
		
		ItemOptionsAndTypes itemOptionsAndTypes = new ItemOptionsAndTypes();

		itemOptionsAndTypes.setItemOptionsResponse(
					getItemOptionsFromCategory(itemCategory)
					.stream().map(this::mapItemOptionToDto)
					.collect(Collectors.toList())
				);
		
		itemOptionsAndTypes.setItemTypesResponse(
					getItemTypesFromCategory(itemCategory)
					.stream().map(this::mapItemTypeToDto)
					.collect(Collectors.toList())
				);
		
		return itemOptionsAndTypes;
	}
	
	private List<ItemOption> getItemOptionsFromCategory(ItemCategory itemCategory){
		List<ItemCategoryOption> itemCategoryOptions = itemCategory.getItemCategoryOptions();
		
		if(itemCategoryOptions != null) {
			List<ItemOption> itemOptions = new ArrayList<ItemOption>();			
			for(ItemCategoryOption itemCategoryOption: itemCategoryOptions) {
				itemOptions.add(itemCategoryOption.getItemOption());
			}			
			return itemOptions;
		}		
		return null;
	}
	
	private List<ItemType> getItemTypesFromCategory(ItemCategory itemCategory){
		List<ItemCategoryType> itemCategoryTypes = itemCategory.getItemCategoryTypes();
		if(itemCategoryTypes != null) {
			List<ItemType> itemTypes = new ArrayList<ItemType>();			
			for(ItemCategoryType itemCategoryType: itemCategoryTypes) {
				itemTypes.add(itemCategoryType.getItemType());
			}			
			return itemTypes;
		}
		return null;
	}
	
	private ItemOptionResponse mapItemOptionToDto(ItemOption itemOption) {
		ItemOptionResponse itemOptionsResponse = new ItemOptionResponse();
		itemOptionsResponse.setId(itemOption.getItem_option_id());
		itemOptionsResponse.setName(itemOption.getName());
		
		return itemOptionsResponse;
	}
	
	private ItemTypeResponse mapItemTypeToDto(ItemType itemType) {
		ItemTypeResponse itemTypeResponse = new ItemTypeResponse();
		itemTypeResponse.setId(itemType.getItem_type_id());
		itemTypeResponse.setName(itemType.getName());
		
		return itemTypeResponse;
	}

}
