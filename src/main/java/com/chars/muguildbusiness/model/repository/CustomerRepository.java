package com.chars.muguildbusiness.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chars.muguildbusiness.model.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}