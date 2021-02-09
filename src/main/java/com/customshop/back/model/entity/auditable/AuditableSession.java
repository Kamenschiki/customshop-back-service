package com.customshop.back.model.entity.auditable;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class AuditableSession extends AuditableDateTime {

    @Column(name = "CREATE_SESSION_TOKEN_ID")
    private String createSessionTokenId;

    @Column(name = "UPDATE_SESSION_TOKEN_ID")
    private String updateSessionTokenId;

}
