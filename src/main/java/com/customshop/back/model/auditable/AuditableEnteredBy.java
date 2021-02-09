package com.customshop.back.model.auditable;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Data
@MappedSuperclass
public class AuditableEnteredBy extends AuditableSession{

    @CreatedBy
    @Column(name = "CREATED_BY_ADMIN_ID")
    private UUID createdByAdminId;

    @LastModifiedBy
    @Column(name = "UPDATED_BY_ADMIN_ID")
    private UUID updatedByAdminId;
}
