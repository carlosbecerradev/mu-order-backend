package com.chars.muguildbusiness.controller;

import static org.springframework.http.ResponseEntity.status;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chars.muguildbusiness.dto.UserResponse;
import com.chars.muguildbusiness.model.service.UserService;

@RequestMapping("/api/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/nicknames")
	public ResponseEntity<List<UserResponse>> getNicknames(){
		return status(HttpStatus.OK)
				.body(userService.findAllUsersNickname());
	}
}
