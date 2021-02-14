package com.customshop.back.model.entity.auditable;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class AuditableSession extends AuditableDateTime {

    @Column(name = "create_jwt_token")
    private String createJwtToken;

    @Column(name = "update_jwt_token")
    private String updateJwtToken;

}
