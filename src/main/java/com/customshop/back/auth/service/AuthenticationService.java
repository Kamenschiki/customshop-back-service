package com.customshop.back.auth.service;

import com.customshop.back.model.dto.auth.SignUpReqDto;
import com.customshop.back.model.entity.auditable.AuditableStatus;
import com.customshop.back.model.entity.auth.Role;
import com.customshop.back.model.entity.auth.User;
import com.customshop.back.model.repo.auth.RoleRepo;
import com.customshop.back.model.utils.PersistAuditEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Slf4j
@Service
public class AuthenticationService {

    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private PersistAuditEntityService persistAuditEntityService;

    public UUID userSignUp(SignUpReqDto signUpReqDto) {
        User user = new User(signUpReqDto);
        Role roleUser = roleRepo.findByName("USER");
        user.setRoles(new ArrayList<>());
        user.getRoles().add(roleUser);

        user.setUserId(UUID.randomUUID());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAuditableStatus(AuditableStatus.ACTIVE);

        persistAuditEntityService.upsert(user);
        log.info("User with id: {} saved", user.getUserId());
        return user.getUserId();
    }

}
