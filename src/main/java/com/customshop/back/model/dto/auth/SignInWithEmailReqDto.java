package com.customshop.back.model.dto.auth;

import lombok.Data;

@Data
public class SignInWithEmailReqDto {
    private String email;
    private String password;
}
