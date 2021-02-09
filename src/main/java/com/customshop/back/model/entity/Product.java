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
@Table(name = "products")
@EqualsAndHashCode(callSuper = true)
public class Product extends AuditableEnteredBy {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "product_id")
    private UUID productId;

    @Type(type = "uuid-char")
    @Column(name = "product_type_id")
    private UUID productTypeId;

    @Type(type = "uuid-char")
    @Column(name = "product_type_category_id")
    private UUID productTypeCategoryId;

    @Type(type = "uuid-char")
    @Column(name = "sale_id")
    private UUID saleId;

    @Column(name = "location")
    private String location;
}
