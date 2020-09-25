package com.chars.muguildbusiness.auth.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chars.muguildbusiness.model.entity.Role;
import com.chars.muguildbusiness.model.entity.Usuario;
import com.chars.muguildbusiness.model.repository.IUsuarioRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Usuario> usuarioOptinal = usuarioRepository.findByUsername(username);
		
		Usuario usuario = usuarioOptinal.orElseThrow( () -> 
					new UsernameNotFoundException("No user found with username : " + username ));
		
		return new User(usuario.getUsername(), 
				usuario.getPassword(), usuario.getEnabled(), 
				true, true, true, getAuthorities(usuario));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(Usuario usuario) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(Role role : usuario.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
		return authorities;
	}

}
