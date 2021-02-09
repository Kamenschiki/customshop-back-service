package com.customshop.back.model.entity;

import com.customshop.back.model.auditable.AuditableEnteredBy;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "PRODUCT_TYPE_CATEGORIES")
@EqualsAndHashCode(callSuper = true)
public class ProductTypeCategory extends AuditableEnteredBy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_TYPE_CATEGORY_ID")
    private UUID productTypeCategoryId;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;
}
