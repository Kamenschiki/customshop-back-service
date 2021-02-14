package com.customshop.back.query.service;

import com.customshop.back.auth.security.jwt.JwtTokenProvider;
import com.customshop.back.model.dao.UserDao;
import com.customshop.back.model.dto.query.rec.GetFilteredUserListReqDto;
import com.customshop.back.model.dto.query.res.GetFilteredUserListResDto;
import com.customshop.back.model.dto.query.res.GetUserDataResDto;
import com.customshop.back.model.entity.auth.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class AdminPanelQueryService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public GetUserDataResDto getUserData(UUID userId) {
        User userFromDb = userDao.findByPk(userId);
        return new GetUserDataResDto(userFromDb);
    }

    public List<GetFilteredUserListResDto> getFilteredUsersList(GetFilteredUserListReqDto getFilteredUserListReqDto) {
        List<GetFilteredUserListResDto> userFromDb = userDao.getFilteredUserList(getFilteredUserListReqDto);

        return userFromDb;
    }
}
