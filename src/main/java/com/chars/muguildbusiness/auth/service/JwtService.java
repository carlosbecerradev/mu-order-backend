package com.chars.muguildbusiness.auth.service;

import java.io.IOException;

import org.springframework.security.core.Authentication;

public interface JwtService {

	String create(Authentication authResult) throws IOException;

	boolean validate(String header);

	String getUsernameFromToken(String header);

}
