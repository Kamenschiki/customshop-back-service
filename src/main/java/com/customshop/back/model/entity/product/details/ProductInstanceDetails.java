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
@Table(name = "PRODUCT_INSTANCE_DETAILS")
@EqualsAndHashCode(callSuper = true)
@TypeDefs({ @TypeDef(name = "primitive-array", typeClass = Array.class) })
public class ProductInstanceDetails extends BasicDetails {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "PRODUCT_INSTANCE_DETAIL_ID")
    private UUID productInstanceDetailId;

    @Type(type = "uuid-char")
    @Column(name = "PRODUCT_INSTANCE_ID")
    private UUID productInstanceId;

    @Override
    public UUID getPrimaryKey() {
        return productInstanceDetailId;
    }
}
