package com.customshop.back.model.entity.product.details;

import com.customshop.back.model.entity.BasicDetails;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "PRODUCT_CATEGORY_DETAILS")
@EqualsAndHashCode(callSuper = true)
public class ProductCategoryDetails extends BasicDetails {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "PRODUCT_CATEGORY_DETAIL_ID")
    private UUID productCategoryDetailsId;

    @Type(type = "uuid-char")
    @Column(name = "PRODUCT_CATEGORY_ID")
    private UUID productCategoryId;

    @Override
    public UUID getPrimaryKey() {
        return productCategoryDetailsId;
    }
}
