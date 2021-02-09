package com.customshop.back.model.dao;

import com.customshop.back.model.entity.User;
import com.customshop.back.model.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class UserDao {

    @Autowired
    private UserRepo userRepo;

    public User findByName(String username) {
        User user = userRepo.findByName(username)
                .orElseThrow(() -> new RuntimeException("404 User with username: " + username + " not found"));
        log.info("User with name: {} found", username);
        return user;
    }

    public User findByEmail(String email) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("404 User with email: " + email + " not found"));
        log.info("User with email: {} found", email);
        return user;
    }

    public User findByUserId(UUID id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("404 User with id: " + id.toString() + " not found"));
        log.info("User with id {} found", id);
        return user;
    }

}
