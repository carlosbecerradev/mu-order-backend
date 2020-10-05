package com.chars.muguildbusiness.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_category_options")
public class ItemCategoryOption implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long item_category_option_id;
	private Boolean enabled;
	
	public Long getItem_category_option_id() {
		return item_category_option_id;
	}
	public void setItem_category_option_id(Long item_category_option_id) {
		this.item_category_option_id = item_category_option_id;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
