package com.customshop.back.command.service;

import com.customshop.back.model.dao.UserDao;
import com.customshop.back.model.dto.command.req.UserReqDto;
import com.customshop.back.model.entity.auth.User;
import com.customshop.back.model.entity.auth.details.UserDetails;
import com.customshop.back.model.mappers.product.UserDtoToUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminPanelUserCommandService
        extends AdminPanelCommandService<User, UserDetails, UserDao, UserReqDto, UserDtoToUserMapper> {

    @Autowired
    private UserDao userDao;
    private final UserDtoToUserMapper userDtoToUserMapper = UserDtoToUserMapper.INSTANCE;

    @Override
    protected UserDao getDao() {
        return this.userDao;
    }

    @Override
    protected UserDtoToUserMapper getMapper() {
        return this.userDtoToUserMapper;
    }

    @Override
    protected UserDetails getDetails() {
        return new UserDetails();
    }
}
