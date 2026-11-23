package com.beautigo.model.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beautigo.model.Users;
import com.beautigo.service.UsersService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("customers/")
public class UsersController {

	private final UsersService userService;

	@PostMapping("/add")
	public Users addUser(@RequestBody Users user) {
		return userService.addUser(user);
	}

	@GetMapping("/{id}")
	public Users getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

}
