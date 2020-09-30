package com.chars.muguildbusiness.auth.service;

import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Collection;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JwtServiceImpl implements JwtService {

	public static final long ONE_MINUTE_TO_MILLIS = 60000L;
	public static final long EXPIRATION_TIME = ONE_MINUTE_TO_MILLIS*1;
	
	private KeyStore keyStore;
	
	@PostConstruct
	public void init() {
		try {
			keyStore = KeyStore.getInstance("JKS");
			InputStream resourceAsStream = getClass().getResourceAsStream("/muguildbusiness.jks");
			keyStore.load(resourceAsStream, "secret".toCharArray());
		} catch (KeyStoreException | CertificateException | 
				NoSuchAlgorithmException | IOException e) {
			throw new RuntimeException("Exception ocurred while loading keystore", e);
		}
	}
	
	@Override
	public String create(Authentication authResult) throws IOException {

		String username = authResult.getName();
		
		Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();
		
		Claims claims = Jwts.claims();
		claims.put("authorities", new ObjectMapper().writeValueAsString(authorities));
		
		String token = Jwts.builder()
						.setClaims(claims)
						.setSubject(username)
						.signWith(getPrivateKey())
						.setIssuedAt(new Date())
						.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
						.compact();
		
		return token;
	}

	private Key getPrivateKey() {

		try {
			return keyStore.getKey("muguildbusiness", "secret".toCharArray());
		} catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
			throw new RuntimeException("Exception ocurred while retrieving private key from keystore", e);
		}

	}
	
	
	
	
	
	
	
	

}
