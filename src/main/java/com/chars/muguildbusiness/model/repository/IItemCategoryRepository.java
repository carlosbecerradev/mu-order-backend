package com.chars.muguildbusiness.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chars.muguildbusiness.model.entity.ItemCategory;

@Repository
public interface IItemCategoryRepository extends JpaRepository<ItemCategory, Long> {

}
