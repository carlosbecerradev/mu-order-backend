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
	List<Order> findByEnabledTrueAndItem(Item item);
	List<Order> findByEnabledTrueAndItemItemCategory(ItemCategory itemCategory);
	
	List<Order> findByEnabledTrueAndUser(Usuario user);
	List<Order> findByEnabledTrueAndUserAndItem(Usuario user, Item item);
	List<Order> findByEnabledTrueAndUserAndItemItemCategory(Usuario user, ItemCategory itemCategory);
}
