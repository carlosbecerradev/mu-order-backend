package com.chars.muguildbusiness.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chars.muguildbusiness.model.entity.ItemCategory;

@Repository
public interface IItemCategoryRepository extends JpaRepository<ItemCategory, Long> {
	Optional<ItemCategory> findByName(String name);	
	List<ItemCategory> findByEnabledTrue();
}
