package com.customshop.back.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignInResDto {
    private String userId;
    private String token;
}
