package com.chars.muguildbusiness.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chars.muguildbusiness.model.entity.Item;
import com.chars.muguildbusiness.model.entity.ItemCategory;
import com.chars.muguildbusiness.model.entity.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByItem(Item item);
	List<Order> findByItemItemCategory(ItemCategory itemCategory);
}
