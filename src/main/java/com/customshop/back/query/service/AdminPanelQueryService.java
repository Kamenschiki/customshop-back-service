package com.customshop.back.query.service;

import com.customshop.back.model.dao.UserDao;
import com.customshop.back.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class AdminPanelQueryService {

    @Autowired
    private UserDao userDao;

    public User findUserByUserId(UUID userId) {
        return userDao.findByUserId(userId);
    }
}
