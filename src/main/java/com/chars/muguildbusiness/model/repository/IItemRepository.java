package com.chars.muguildbusiness.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chars.muguildbusiness.model.entity.Item;

@Repository
public interface IItemRepository extends JpaRepository<Item, Long> {
	Optional<Item> findByName(String name);
	List<Item> findByNameIgnoreCaseContaining(String name, Pageable pageable);
}
