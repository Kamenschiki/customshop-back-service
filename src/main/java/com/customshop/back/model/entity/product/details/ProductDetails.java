package com.customshop.back.model.entity.product.details;

import com.customshop.back.model.entity.BasicDetails;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.sql.Array;
import java.util.UUID;

@Data
@Entity
@Table(name = "PRODUCT_DETAILS")
@EqualsAndHashCode(callSuper = true)
@TypeDefs({ @TypeDef(name = "primitive-array", typeClass = Array.class) })
public class ProductDetails extends BasicDetails {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "PRODUCT_DETAIL_ID")
    private UUID productDetailId;

    @Type(type = "uuid-char")
    @Column(name = "PRODUCT_ID")
    private UUID productId;

    @Override
    public UUID getPrimaryKey() {
        return productDetailId;
    }
}
