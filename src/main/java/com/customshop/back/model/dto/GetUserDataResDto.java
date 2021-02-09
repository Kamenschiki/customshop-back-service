package com.customshop.back.model.dto;

import com.customshop.back.model.entity.Role;
import com.customshop.back.model.entity.User;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class GetUserDataResDto {
    private String userId;
    private String username;
    private String email;
    private List<String> roleNames;

    public GetUserDataResDto(User user) {
        this.userId = user.getUserId().toString();
        this.username = user.getName();
        this.email = user.getEmail();
        this.roleNames = user.getRoles().stream().map(Role::getName).collect(Collectors.toList());
    }
}
