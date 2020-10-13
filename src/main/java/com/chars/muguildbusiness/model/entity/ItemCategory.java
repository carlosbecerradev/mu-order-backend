package com.chars.muguildbusiness.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "item_categories")
public class ItemCategory implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long item_category_id;
	@Column(length = 50, unique = true, nullable = false)
	private String name;
	@Column(nullable = false)
	private Boolean enabled;

	@OneToMany(mappedBy = "itemCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ItemCategoryOption> itemCategoryOptions;

	@OneToMany(mappedBy = "itemCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ItemCategoryType> itemCategoryTypes;
	
	@OneToMany(mappedBy = "itemCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Item> items;

	public Long getItem_category_id() {
		return item_category_id;
	}

	public void setItem_category_id(Long item_category_id) {
		this.item_category_id = item_category_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<ItemCategoryOption> getItemCategoryOptions() {
		return itemCategoryOptions;
	}

	public void setItemCategoryOptions(List<ItemCategoryOption> itemCategoryOptions) {
		this.itemCategoryOptions = itemCategoryOptions;
	}

	public List<ItemCategoryType> getItemCategoryTypes() {
		return itemCategoryTypes;
	}

	public void setItemCategoryTypes(List<ItemCategoryType> itemCategoryTypes) {
		this.itemCategoryTypes = itemCategoryTypes;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
}
