package com.chars.muguildbusiness.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chars.muguildbusiness.model.entity.Usuario;

@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Long> {

	Optional<Usuario> findByUsername(String username);
	boolean existsByUsername(String username);
	boolean existsByEmail(String email);	
	List<Usuario> findByEnabledTrueOrderByNickname();
}
