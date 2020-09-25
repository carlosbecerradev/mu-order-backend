package com.chars.muguildbusiness.auth.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chars.muguildbusiness.dto.RegisterRequest;
import com.chars.muguildbusiness.model.entity.Role;
import com.chars.muguildbusiness.model.entity.Usuario;
import com.chars.muguildbusiness.model.repository.IUsuarioRepository;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void signup(RegisterRequest registerRequest) {
		
		Usuario usuario = new Usuario();
		usuario.setUsername(registerRequest.getUsername());
		usuario.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		usuario.setEmail(registerRequest.getEmail());
		usuario.setCreated(Instant.now());
		usuario.setEnabled(false);
		
		usuario.setRoles(setRoleUser());
		
		
		usuarioRepository.save(usuario);
		
	}

	private List<Role> setRoleUser() {
		Role rol = new Role();
		rol.setAuthority("ROLE_USER");
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(rol);
		
		return roles;
	}

}
