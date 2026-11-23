package com.beautigo.service.impl;

import org.springframework.stereotype.Service;

import com.beautigo.model.Users;
import com.beautigo.repo.UserRepossitory;
import com.beautigo.service.UsersService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

	private final UserRepossitory userRepository;

	@Override
	public Users addUser(Users user) {
		return userRepository.save(user);
	}

	@Override
	public Users getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

}
