package com.customshop.back.model.entity;

import com.customshop.back.model.auditable.AuditableEnteredBy;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "sales")
@EqualsAndHashCode(callSuper = true)
public class Sale extends AuditableEnteredBy {

    @Id
    @Column(name = "sale_id")
    private UUID saleId;

    @Column(name = "description")
    private String description;

    @Column(name = "percent_value")
    private Integer percentValue;
}
