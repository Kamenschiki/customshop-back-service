package com.customshop.back.model.entity;

import com.customshop.back.model.entity.auditable.AuditableEnteredBy;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "sales")
@EqualsAndHashCode(callSuper = true)
public class Sale extends AuditableEnteredBy {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "sale_id")
    private UUID saleId;

    @Column(name = "description")
    private String description;

    @Column(name = "percent_value")
    private Integer percentValue;
}
