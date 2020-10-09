package com.chars.muguildbusiness.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chars.muguildbusiness.model.entity.Usuario;
import com.chars.muguildbusiness.model.repository.IUsuarioRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private IUsuarioRepository userRepository;

	@Override
	public Usuario findByUsername(String username) {
		return userRepository.findByUsername(username)
				.orElse(null);
	}

}
