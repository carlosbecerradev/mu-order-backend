package com.chars.muguildbusiness.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chars.muguildbusiness.model.entity.Item;
import com.chars.muguildbusiness.model.entity.ItemCategory;
import com.chars.muguildbusiness.model.entity.OrderHistory;
import com.chars.muguildbusiness.model.entity.Usuario;

@Repository
public interface IOrderHistoryRepository extends JpaRepository<OrderHistory, Long> {
	public Page<OrderHistory> findByOrderUser(Usuario user, Pageable pageable);
	public Page<OrderHistory> findByOrderItemItemCategoryAndOrderUser(ItemCategory itemCategory, Usuario user, Pageable pageable);
	public Page<OrderHistory> findByOrderItemAndOrderUser(Item item, Usuario user, Pageable pageable);
}
