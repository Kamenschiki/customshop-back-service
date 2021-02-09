package com.customshop.back.model.dto;

import lombok.Data;

@Data
public class SignInWithEmailReqDto {
    private String email;
    private String password;
}
