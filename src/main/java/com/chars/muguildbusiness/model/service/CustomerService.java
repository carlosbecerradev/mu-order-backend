package com.chars.muguildbusiness.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chars.muguildbusiness.model.entity.Customer;
import com.chars.muguildbusiness.model.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Transactional(readOnly = true)
	public List<Customer> getAll(){
		return (List<Customer>) customerRepository.findAll();
	}
}
