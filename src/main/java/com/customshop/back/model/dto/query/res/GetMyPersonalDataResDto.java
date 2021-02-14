package com.customshop.back.model.dto.query.res;

import com.customshop.back.model.entity.auth.User;
import lombok.Data;

@Data
public class GetMyPersonalDataResDto {
    private String username;
    private String email;

    public GetMyPersonalDataResDto(User user) {
        this.username = user.getName();
        this.email = user.getEmail();
    }
}
