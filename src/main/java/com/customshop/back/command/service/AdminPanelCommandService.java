package com.customshop.back.command.service;

import com.customshop.back.model.dao.UserDao;
import com.customshop.back.model.entity.User;
import com.customshop.back.model.entity.auditable.AuditableStatus;
import com.customshop.back.model.utils.PersistAuditEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class AdminPanelCommandService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PersistAuditEntityService persistUserEntityService;

    public void activateUser(UUID userId) {
        User userToInactivate = userDao.findByUserId(userId);
        userToInactivate.setAuditableStatus(AuditableStatus.INACTIVE);
        persistUserEntityService.upsert(userToInactivate);

        log.info("User with username: {} activated", userId);
    }

    public void inactivateUser(UUID userId) {
        User userToInactivate = userDao.findByUserId(userId);
        userToInactivate.setAuditableStatus(AuditableStatus.INACTIVE);
        persistUserEntityService.upsert(userToInactivate);

        log.info("User with username: {} inactivated", userId);
    }

    public void deleteUser(UUID userId) {
        User userToDelete = userDao.findByUserId(userId);
        userToDelete.setAuditableStatus(AuditableStatus.DELETED);
        persistUserEntityService.upsert(userToDelete);

        log.info("User with username: {} deleted", userId);
    }

}
