package com.customshop.back.model.dto.command.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserReqDto extends DetailedReqBasicDto {

    private UUID userId;
    private String name;
    private String email;

    @Override
    public UUID getPk() {
        return userId;
    }
}
