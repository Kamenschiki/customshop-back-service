package com.customshop.back.model.entity;

import com.customshop.back.model.entity.auditable.AuditableSession;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
//TODO: rename all Details to Detail
public abstract class BasicDetails extends AuditableSession {

    @Column(name = "DETAIL_TYPE")
    private String detailType;

    @Column(name = "DETAIL_TEXT")
    private String detailText;

    public abstract UUID getPrimaryKey();

}
