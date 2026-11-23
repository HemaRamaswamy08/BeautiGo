package com.beautigo.service;

import com.beautigo.model.Users;

public interface UsersService {

	Users addUser(Users user);

	Users getUserById(Long id);

}
