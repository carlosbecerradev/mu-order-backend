package com.chars.muguildbusiness.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chars.muguildbusiness.dto.UserResponse;
import com.chars.muguildbusiness.model.entity.Usuario;
import com.chars.muguildbusiness.model.repository.IUsuarioRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private IUsuarioRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsername(String username) {
		return userRepository.findByUsername(username)
				.orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserResponse> findAllUsersNickname() {
		return userRepository.findByEnabledTrueOrderByNickname()
				.stream()
				.map(this::mapToDto)
				.collect(Collectors.toList());
	}
	
	private UserResponse mapToDto(Usuario usuario) {
		UserResponse userResponse = new UserResponse();
		userResponse.setId(usuario.getUser_id());
		userResponse.setNickname(usuario.getNickname());
		return userResponse;
	}

}
