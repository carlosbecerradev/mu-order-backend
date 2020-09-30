package com.chars.muguildbusiness.auth.service;

import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.annotation.PostConstruct;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;

@Service
public class JwtServiceImpl implements JwtService {

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
	public String create(Authentication authResult) {

		String username = authResult.getName();
		
		String token = Jwts.builder()
						.setSubject(username)
						.signWith(getPrivateKey())
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
