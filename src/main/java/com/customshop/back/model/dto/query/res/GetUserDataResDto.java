package com.customshop.back.model.dto.query.res;

import com.customshop.back.model.entity.auditable.AuditableStatus;
import com.customshop.back.model.entity.auth.Role;
import com.customshop.back.model.entity.auth.User;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class GetUserDataResDto {
    private String userId;
    private String username;
    private String email;
    private String lastUpdatedByUsername;
    private Timestamp lastUpdatedDateTimeUtc;
    private AuditableStatus auditableStatus;
    private List<String> roleNames;

    public GetUserDataResDto(User user) {
        this.userId = user.getUserId().toString();
        this.username = user.getName();
        this.email = user.getEmail();
        this.lastUpdatedDateTimeUtc = user.getUpdateDateTimeUtc();
        this.auditableStatus = user.getAuditableStatus();
        this.roleNames = user.getRoles().stream().map(Role::getName).collect(Collectors.toList());
    }
}
