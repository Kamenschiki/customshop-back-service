package com.customshop.back.model.dto.auth;

import lombok.Data;

@Data
public class SignUpReqDto {
    private String name;
    private String password;
    private String email;
}
