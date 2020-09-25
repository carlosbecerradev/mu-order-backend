package com.chars.muguildbusiness.model.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chars.muguildbusiness.model.entity.VerificationEmailToken;

@Repository
public interface VerificationEmailTokenRepository extends CrudRepository<VerificationEmailToken, Long> {

	Optional<VerificationEmailToken> findByToken(String token);
}
