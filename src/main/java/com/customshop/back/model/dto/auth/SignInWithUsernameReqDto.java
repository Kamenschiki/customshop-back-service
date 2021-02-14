package com.customshop.back.model.dto.auth;

import lombok.Data;

@Data
public class SignInWithUsernameReqDto {
    private String username;
    private String password;
}
