package com.customshop.back.model.dao;

import com.customshop.back.model.dto.query.rec.GetFilteredUserListReqDto;
import com.customshop.back.model.dto.query.res.GetFilteredUserListResDto;
import com.customshop.back.model.entity.auth.User;
import com.customshop.back.model.repo.auth.UserRepo;
import com.customshop.back.model.utils.ResourcesUtils;
import com.customshop.back.model.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class UserDao implements BasicDao<User> {

    @Autowired
    private UserRepo userRepo;

    @PersistenceContext
    private EntityManager entityManager;

    private static final String GET_FILTERED_USER_LIST = ResourcesUtils.getResourceFile("sql/getFilteredUserList.sql");

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

    public User findByPk(UUID id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("404 User with id: " + id.toString() + " not found"));
        log.info("User with id {} found", id);
        return user;
    }

    public List<User> findByPkIn(List<UUID> ids) {
        List<User> users = userRepo.findAllByUserIdIn(ids);
        log.info("User with id in {} found: {}", ids.toString(), users.size());
        return users;
    }

    public List<GetFilteredUserListResDto> getFilteredUserList(GetFilteredUserListReqDto getFilteredUserListReqDto) {
        int firstEntityNumber = (getFilteredUserListReqDto.getPageNumber() - 1)
                * getFilteredUserListReqDto.getItemNumberByPage();

        Query query = entityManager.createNativeQuery(GET_FILTERED_USER_LIST);
        query.setParameter("userName", getFilteredUserListReqDto.getUserName());
        query.setParameter("email", getFilteredUserListReqDto.getEmail());
        query.setParameter("auditableStatus", getFilteredUserListReqDto.getAuditableStatus());
        query.setParameter("createdAfter", StringUtils.toString(getFilteredUserListReqDto.getCreatedAfter()));
        query.setParameter("createdBefore", StringUtils.toString(getFilteredUserListReqDto.getCreatedBefore()));
        query.setParameter("lastUpdatedAfter", StringUtils.toString(getFilteredUserListReqDto.getLastUpdatedAfter()));
        query.setParameter("lastUpdatedBefore", StringUtils.toString(getFilteredUserListReqDto.getLastUpdatedBefore()));
        query.setFirstResult(firstEntityNumber);
        query.setMaxResults(getFilteredUserListReqDto.getItemNumberByPage());
        return (List<GetFilteredUserListResDto>) query.getResultList();
    }
}
