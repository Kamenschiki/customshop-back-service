package com.customshop.back.model.dto.query.rec;

import com.customshop.back.model.entity.auditable.AuditableStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class GetFilteredUserListReqDto extends Paginated {
    private String email;
    private String userName;
    private AuditableStatus auditableStatus;
    private LocalDateTime lastUpdatedBefore;
    private LocalDateTime lastUpdatedAfter;
    private LocalDateTime createdBefore;
    private LocalDateTime createdAfter;
}
