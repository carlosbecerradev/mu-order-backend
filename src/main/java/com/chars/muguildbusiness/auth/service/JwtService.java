package com.chars.muguildbusiness.auth.service;

import org.springframework.security.core.Authentication;

public interface JwtService {

	String create(Authentication authResult);

}
