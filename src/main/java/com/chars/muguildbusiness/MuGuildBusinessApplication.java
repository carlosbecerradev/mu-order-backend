package com.chars.muguildbusiness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class MuGuildBusinessApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MuGuildBusinessApplication.class, args);
	}

}
