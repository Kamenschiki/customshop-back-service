package com.customshop.back.model.entity;

import com.customshop.back.model.entity.auditable.AuditableEnteredBy;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity(name = "product_types")
@Table(name = "product_types")
@EqualsAndHashCode(callSuper = true)
public class ProductType extends AuditableEnteredBy {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "product_type_id")
    private UUID productTypeId;

    @Type(type = "uuid-char")
    @Column(name = "product_type_category_id")
    private UUID productTypeCategoryId;

    @Type(type = "uuid-char")
    @Column(name = "sale_id")
    private UUID saleId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "available_flag")
    private Boolean availableFlag;
}
