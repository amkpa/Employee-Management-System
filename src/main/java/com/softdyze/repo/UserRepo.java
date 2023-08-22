package com.softdyze.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softdyze.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
