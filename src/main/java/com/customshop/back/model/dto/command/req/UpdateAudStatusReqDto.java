package com.customshop.back.model.dto.command.req;

import com.customshop.back.model.entity.auditable.AuditableStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class UpdateAudStatusReqDto {

    private UUID pk;
    private AuditableStatus auditableStatus;
    private String audStatusUpdateReason;

}
