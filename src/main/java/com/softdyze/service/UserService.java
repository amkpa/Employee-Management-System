package com.softdyze.service;

import com.softdyze.entity.User;

public interface UserService {
	User createUser(User user);

	User findUserByUsername(String username);

	User loginUser(String username, String password);

}
