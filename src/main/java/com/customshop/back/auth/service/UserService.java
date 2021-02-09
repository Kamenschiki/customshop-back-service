package com.customshop.back.auth.service;

import com.customshop.back.model.auditable.AuditableStatus;
import com.customshop.back.model.dto.SignUpReqDto;
import com.customshop.back.model.entity.Role;
import com.customshop.back.model.entity.User;
import com.customshop.back.model.repo.RoleRepo;
import com.customshop.back.model.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UUID userSignUp(SignUpReqDto signUpReqDto){
        User user = new User(signUpReqDto);
        Role roleUser = roleRepo.findByName("USER");
        user.setRoles(new ArrayList<>());
        user.getRoles().add(roleUser);

        user.setUserId(UUID.randomUUID());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAuditableStatus(AuditableStatus.ACTIVE);

        User registeredUser = userRepo.save(user);
        log.info("User with id: {} saved",user.getUserId());
        return registeredUser.getUserId();
    }

    public List<User> getAll(){
        List<User> users = userRepo.findAll();
        log.info("Number of users found: {}", users.size());
        return users;
    }

    public User findByUsername(String username){
        User user = userRepo.findByName(username).orElseThrow(
                () -> new RuntimeException("404 User with username: " + username + " not found"));
        log.info("User with name: {} found", username);
        return user;
    }

    public User findByEmail(String email){
        User user = userRepo.findByEmail(email).orElseThrow(
                () -> new RuntimeException("404 User with email: " + email + " not found"));
        log.info("User with email: {} found", email);
        return user;
    }

    public User findById(UUID id){
        User user = userRepo.findById(id).orElseThrow(
                () -> new RuntimeException("404 User with id: " + id.toString() + " not found"));
        log.info("User with id {} found", id);
        return user;
    }

    public void delete(UUID id){
        userRepo.deleteById(id);
        log.info("User with id {} deleted", id);
    }

}
