package com.chars.muguildbusiness.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chars.muguildbusiness.model.entity.Item;
import com.chars.muguildbusiness.model.entity.ItemCategory;
import com.chars.muguildbusiness.model.entity.OrderHistory;
import com.chars.muguildbusiness.model.entity.Usuario;

@Repository
public interface IOrderHistoryRepository extends JpaRepository<OrderHistory, Long> {
	public List<OrderHistory> findByOrderUser(Usuario user);
	public List<OrderHistory> findByOrderItemItemCategoryAndOrderUser(ItemCategory itemCategory, Usuario user);
	public List<OrderHistory> findByOrderItemAndOrderUser(Item item, Usuario user);
}
