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
@Table(name = "item_options")
public class ItemOption implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long item_option_id;
	@Column(unique = true, length = 50, nullable = false)
	private String name;
	@Column(nullable = false)
	private Boolean enabled;
	
	@OneToMany(mappedBy = "itemOption", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ItemCategoryOption> itemCategoryOptions;

	public Long getItem_option_id() {
		return item_option_id;
	}

	public void setItem_option_id(Long item_option_id) {
		this.item_option_id = item_option_id;
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
	
	
}
