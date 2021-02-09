package com.customshop.back.model.entity.auditable;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@MappedSuperclass
public class AuditableDateTime {

    @CreatedDate
    @Column(name = "create_date_time_utc")
    private Timestamp createDateTimeUtc;

    @LastModifiedDate
    @Column(name = "update_date_time_utc")
    private Timestamp updateDateTimeUtc;

    @Type(type = "uuid-char")
    @Column(name = "delete_info_id")
    private UUID deleteInfoId;

    @Type(type = "uuid-char")
    @Column(name = "inactivate_info_id")
    private UUID inactivateInfoId;

    @Enumerated(EnumType.STRING)
    @Column(name = "auditable_status")
    private AuditableStatus auditableStatus;
}
