package com.customshop.back.model.entity;

import com.customshop.back.model.auditable.AuditableEnteredBy;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity(name = "product_types")
@Table(name = "product_types")
@EqualsAndHashCode(callSuper = true)
public class ProductType extends AuditableEnteredBy {

    @Id
    @Column(name = "product_type_id")
    private UUID productTypeId;

    @Column(name = "product_type_category_id")
    private UUID productTypeCategoryId;

    @Column(name = "sale_id")
    private UUID saleId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "available_flag")
    private Boolean availableFlag;
}
