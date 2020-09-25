package com.chars.muguildbusiness.auth.service;

import com.chars.muguildbusiness.dto.RegisterRequest;

public interface AuthService {

	public void signup(RegisterRequest registerRequest);

	public void verifyAccount(String token);
}
