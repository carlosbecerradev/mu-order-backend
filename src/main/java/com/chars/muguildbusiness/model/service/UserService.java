package com.chars.muguildbusiness.model.service;

import java.util.List;

import com.chars.muguildbusiness.dto.UserResponse;
import com.chars.muguildbusiness.model.entity.Usuario;

public interface UserService {
	public Usuario findByUsername(String username);
	public List<UserResponse> findAllUsersNickname();
}
