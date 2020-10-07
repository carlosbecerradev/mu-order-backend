package com.chars.muguildbusiness.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chars.muguildbusiness.model.entity.ItemType;

@Repository
public interface IItemTypeRepository extends CrudRepository<ItemType, Long> {

}
