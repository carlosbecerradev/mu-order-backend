package com.chars.muguildbusiness.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chars.muguildbusiness.model.entity.Item;
import com.chars.muguildbusiness.model.entity.ItemCategory;
import com.chars.muguildbusiness.model.entity.Order;
import com.chars.muguildbusiness.model.entity.Usuario;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByEnabledTrueOrderByCreatedDesc();
	List<Order> findByEnabledTrueAndItemOrderByCreatedDesc(Item item);
	List<Order> findByEnabledTrueAndItemItemCategoryOrderByCreatedDesc(ItemCategory itemCategory);
	
	List<Order> findByEnabledTrueAndUserOrderByCreatedDesc(Usuario user);
	List<Order> findByEnabledTrueAndUserAndItemOrderByCreatedDesc(Usuario user, Item item);
	List<Order> findByEnabledTrueAndUserAndItemItemCategoryOrderByCreatedDesc(Usuario user, ItemCategory itemCategory);
}
