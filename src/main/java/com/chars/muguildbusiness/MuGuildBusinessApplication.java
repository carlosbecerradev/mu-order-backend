package com.chars.muguildbusiness;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.chars.muguildbusiness.model.entity.Role;
import com.chars.muguildbusiness.model.entity.Usuario;
import com.chars.muguildbusiness.model.repository.IUsuarioRepository;

@SpringBootApplication
public class MuGuildBusinessApplication implements CommandLineRunner {

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(MuGuildBusinessApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		String password = "any@gmal.com";
		String result = passwordEncoder.encode(password);
		
		System.out.println(password);
		System.out.println(result);
		
		
	}
	
	

}
