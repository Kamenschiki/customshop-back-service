package com.customshop.back.model.entity;

import com.customshop.back.model.auditable.AuditableEnteredBy;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "products")
@EqualsAndHashCode(callSuper = true)
public class Product extends AuditableEnteredBy {

    @Id
    @Column(name = "product_id")
    private UUID productId;

    @Column(name = "product_type_id")
    private UUID productTypeId;

    @Column(name = "product_type_category_id")
    private UUID productTypeCategoryId;

    @Column(name = "sale_id")
    private UUID saleId;

    @Column(name = "location")
    private String location;
}
