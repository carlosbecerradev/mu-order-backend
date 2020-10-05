package com.chars.muguildbusiness.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_category_types")
public class ItemCategoryType implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long item_category_type_id;
	private Boolean enabled;
	
	public Long getItem_category_type_id() {
		return item_category_type_id;
	}
	public void setItem_category_type_id(Long item_category_type_id) {
		this.item_category_type_id = item_category_type_id;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
}
