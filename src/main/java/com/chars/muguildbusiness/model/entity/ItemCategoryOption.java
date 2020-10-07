package com.chars.muguildbusiness.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "item_category_options", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"item_category_id", "item_option_id"} )}
)
public class ItemCategoryOption implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long item_category_option_id;
	
	@ManyToOne
	@JoinColumn(name = "item_option_id", nullable = false)
	private ItemOption itemOption;
	
	@ManyToOne
	@JoinColumn(name = "item_category_id", nullable = false)
	private ItemCategory itemCategory;
	
	public Long getItem_category_option_id() {
		return item_category_option_id;
	}
	public void setItem_category_option_id(Long item_category_option_id) {
		this.item_category_option_id = item_category_option_id;
	}
	public ItemOption getItemOption() {
		return itemOption;
	}
	public void setItemOption(ItemOption itemOption) {
		this.itemOption = itemOption;
	}
	public ItemCategory getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(ItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}
	
	
}
