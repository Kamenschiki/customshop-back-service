package com.customshop.back.model.entity.auditable;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class AuditableEnteredBy extends AuditableSession {

    @CreatedBy
    @Column(name = "CREATED_BY_ADMIN")
    private String createdByAdmin;

    @LastModifiedBy
    @Column(name = "UPDATED_BY_ADMIN")
    private String updatedByAdmin;
}
