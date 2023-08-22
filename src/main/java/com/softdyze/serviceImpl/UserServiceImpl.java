package com.softdyze.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softdyze.entity.User;
import com.softdyze.repo.UserRepo;
import com.softdyze.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User loginUser(String username, String password) {
        User user = userRepo.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null; // Return null if login fails
    }
}
