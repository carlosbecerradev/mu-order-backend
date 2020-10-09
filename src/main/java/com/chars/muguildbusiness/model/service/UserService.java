package com.chars.muguildbusiness.model.service;

import com.chars.muguildbusiness.model.entity.Usuario;

public interface UserService {
	public Usuario findByUsername(String username);
}
