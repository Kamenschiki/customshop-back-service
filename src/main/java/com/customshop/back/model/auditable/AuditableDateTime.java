package com.customshop.back.model.auditable;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@Data
@MappedSuperclass
public class AuditableDateTime {

    @CreatedDate
    @Column(name = "CREATE_DATE_TIME_UTC")
    private Timestamp createDateTimeUtc;

    @LastModifiedDate
    @Column(name = "UPDATE_DATE_TIME_UTC")
    private Timestamp updateDateTimeUtc;

    @Enumerated(EnumType.STRING)
    @Column(name = "AUDITABLE_STATUS")
    private AuditableStatus auditableStatus;
}
