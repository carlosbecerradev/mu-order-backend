package com.chars.muguildbusiness.auth.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.chars.muguildbusiness.dto.LoginRequest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JwtAuthenticationFilter extends
	UsernamePasswordAuthenticationFilter {
	
	private AuthenticationManager authenticationManager;

	public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
		setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/login", "POST"));
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		String username = "", password = "";
		
		try {
			LoginRequest loginRequest = 
					new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);
			
			username = loginRequest.getUsername();
			password = loginRequest.getPassword();
			
			logger.info("username raw(json): - " + username);
			logger.info("password raw(json): - " + password);
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		username = username.trim();

		UsernamePasswordAuthenticationToken authRequest = 
				new UsernamePasswordAuthenticationToken(
				username, password);
		
		return authenticationManager.authenticate(authRequest);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, 
			HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		response.getWriter().write("Your login was successfully!");
		response.setStatus(200);
		
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, 
			HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {

		response.getWriter().write("Your username or password are incorrect!");
		response.setStatus(401);
		
	}

	
	
	
}
