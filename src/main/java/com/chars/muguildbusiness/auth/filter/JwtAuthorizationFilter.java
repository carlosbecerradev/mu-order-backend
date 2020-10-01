package com.chars.muguildbusiness.auth.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.chars.muguildbusiness.auth.service.JwtService;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
	
	private JwtService jwtService;
	private UserDetailsService userDetailsService;

	public JwtAuthorizationFilter(AuthenticationManager authenticationManager,
			JwtService jwtService, UserDetailsService userDetailsService) {
		super(authenticationManager);
		this.jwtService = jwtService;
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, 
			HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String header = request.getHeader("Authorization");
		
		if(!requireAuthentication(header)) {
			chain.doFilter(request, response);
			return;
		}
		
		UsernamePasswordAuthenticationToken authentication = null;
		
		if(jwtService.validate(header)) {
			
			String username = jwtService.getUsernameFromToken(header);
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			
			authentication = 
					new UsernamePasswordAuthenticationToken(
							username, 
							null, 
							userDetails.getAuthorities());
			
			authentication.setDetails(
					new WebAuthenticationDetailsSource()
							.buildDetails(request));
		}
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(request, response);		
	}

	private boolean requireAuthentication(String header) {

		if(header == null || !header.startsWith("Bearer ")) {
			return false;
		}
		return true;
	}
	
	
	
	
	
	

}
