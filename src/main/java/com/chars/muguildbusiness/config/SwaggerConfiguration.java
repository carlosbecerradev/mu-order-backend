package com.chars.muguildbusiness.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.chars.muguildbusiness.dto.AuthenticationResponse;
import com.chars.muguildbusiness.dto.LoginRequest;
import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	@Autowired
	private TypeResolver typeResolver;
	
	@Bean
	public Docket muGuildBusinessApi() {
		return new Docket(DocumentationType.SWAGGER_2)
					.select()					
					.apis(RequestHandlerSelectors.basePackage("com.chars.muguildbusiness.controller"))
					.build()
					.pathMapping("/")
					.additionalModels(typeResolver.resolve(LoginRequest.class))
					.additionalModels(typeResolver.resolve(AuthenticationResponse.class))
					.apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {		
		return new ApiInfoBuilder()
					.title("Mu Guild Business API")
					.version("1.0")
					.description("API for MU Guild Business Application")
					.contact(new Contact("Carlos Becerra H.", "https://github.com/cbherit", "carlosbecerra.dev@gmail.com"))
					.license("Apache License Version 2.0")
					.build();
	}

}
