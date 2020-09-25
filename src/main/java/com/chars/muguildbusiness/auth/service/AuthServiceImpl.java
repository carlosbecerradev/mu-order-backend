package com.chars.muguildbusiness.auth.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chars.muguildbusiness.dto.RegisterRequest;
import com.chars.muguildbusiness.model.entity.Role;
import com.chars.muguildbusiness.model.entity.Usuario;
import com.chars.muguildbusiness.model.entity.VerificationEmailToken;
import com.chars.muguildbusiness.model.repository.IUsuarioRepository;
import com.chars.muguildbusiness.model.repository.VerificationEmailTokenRepository;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	private VerificationEmailTokenRepository verificationEmailTokenRepository;

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
		
		String token = generateVerificationEmailToken(usuario);
		
	}

	@Transactional
	private String generateVerificationEmailToken(Usuario usuario) {
		
		String token = UUID.randomUUID().toString();
		VerificationEmailToken verificationToken = new VerificationEmailToken();
		verificationToken.setToken(token);
		verificationToken.setUsuario(usuario);
		
		verificationEmailTokenRepository.save(verificationToken);
		
		return token;
	}

	private List<Role> setRoleUser() {
		Role rol = new Role();
		rol.setAuthority("ROLE_USER");
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(rol);
		
		return roles;
	}

	@Override
	public void verifyAccount(String token) {
		Optional<VerificationEmailToken> verificationToken = 
				verificationEmailTokenRepository.findByToken(token);
		
		verificationToken.orElseThrow(()-> new RuntimeException("Invalid token"));
		
		fetchUserAndEnabled(verificationToken.get());
	}

	@Transactional
	private void fetchUserAndEnabled(VerificationEmailToken verificationEmailToken) {

		String username = verificationEmailToken.getUsuario().getUsername();
		Usuario usuario = usuarioRepository.findByUsername(username)
							.orElseThrow(()-> new RuntimeException("User not found"
									+ " with username - " + username));
		usuario.setEnabled(true);
		usuarioRepository.save(usuario);
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
