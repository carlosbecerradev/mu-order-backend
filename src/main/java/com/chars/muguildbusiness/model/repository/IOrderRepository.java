package com.chars.muguildbusiness.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chars.muguildbusiness.model.entity.Item;
import com.chars.muguildbusiness.model.entity.ItemCategory;
import com.chars.muguildbusiness.model.entity.Order;
import com.chars.muguildbusiness.model.entity.Usuario;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
	Page<Order> findByEnabledTrueOrderByCreatedDesc(Pageable pageable);
	Page<Order> findByEnabledTrueAndItemOrderByCreatedDesc(Item item, Pageable pageable);
	Page<Order> findByEnabledTrueAndItemItemCategoryOrderByCreatedDesc(ItemCategory itemCategory, Pageable pageable);
	
	Page<Order> findByEnabledTrueAndUserOrderByCreatedDesc(Usuario user, Pageable pageable);
	Page<Order> findByEnabledTrueAndUserAndItemOrderByCreatedDesc(Usuario user, Item item, Pageable pageable);
	Page<Order> findByEnabledTrueAndUserAndItemItemCategoryOrderByCreatedDesc(Usuario user, ItemCategory itemCategory, Pageable pageable);
}
