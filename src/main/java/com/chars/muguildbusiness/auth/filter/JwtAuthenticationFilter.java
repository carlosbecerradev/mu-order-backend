package com.chars.muguildbusiness.auth.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

import com.chars.muguildbusiness.auth.service.JwtService;
import com.chars.muguildbusiness.dto.LoginRequest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JwtAuthenticationFilter extends
	UsernamePasswordAuthenticationFilter {
	
	private AuthenticationManager authenticationManager;
	private JwtService jwtService;

	public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtService jwtService) {
		this.authenticationManager = authenticationManager;
		setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/login", "POST"));
		this.jwtService = jwtService;
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
		
		String token = jwtService.create(authResult);
		
		response.setHeader("Authorization", "Bearer " + token);
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("token", token);
		body.put("user", authResult.getPrincipal());
		body.put("message", "Your login was successfully!");
		
		response.getWriter().write(new ObjectMapper().writeValueAsString(body));
		response.setStatus(200);
		response.setContentType("application/json");
		
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, 
			HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {

		Map<String, Object> body = new HashMap<String, Object>();
		body.put("message", "Your username or password are incorrect!");
		body.put("error", failed.getMessage());
		
		response.getWriter().write(new ObjectMapper().writeValueAsString(body));
		response.setStatus(401);
		response.setContentType("application/json");
		
	}

	
	
	
}
