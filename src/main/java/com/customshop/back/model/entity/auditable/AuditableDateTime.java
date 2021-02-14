package com.customshop.back.model.entity.auditable;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@Data
@MappedSuperclass
public class AuditableDateTime {

    @Column(name = "CREATE_DATE_TIME_UTC")
    private Timestamp createDateTimeUtc;

    @Column(name = "UPDATE_DATE_TIME_UTC")
    private Timestamp updateDateTimeUtc;

    @Enumerated(EnumType.STRING)
    @Column(name = "AUDITABLE_STATUS")
    private AuditableStatus auditableStatus;

    @Column(name = "AUD_STATUS_UPDATE_REASON")
    private String audStatusUpdateReason;
}
