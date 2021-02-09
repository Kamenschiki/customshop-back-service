//package com.customshop.back.model.entity.auditable;
//
//import lombok.Data;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//import java.util.UUID;
//
//@Data
//@Entity
//@Table(name = "AUDIT_INFO")
//public class AuditInfo {
//
//    @Id
//    private UUID infoId;
//
//    @CreatedDate
//    @Column(name = "create_date_time_utc")
//    private Timestamp createDateTimeUtc;
//
//    @LastModifiedDate
//    @Column(name = "update_date_time_utc")
//    private Timestamp updateDateTimeUtc;
//
//    @Column(name = "delete_info")
//    private UUID deleteInfo;
//
//    @Column(name = "inactivate_info")
//    private UUID inactivateInfo;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "auditable_status")
//    private AuditableStatus auditableStatus;
//}
