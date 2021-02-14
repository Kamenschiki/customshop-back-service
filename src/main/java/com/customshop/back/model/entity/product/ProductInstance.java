package com.customshop.back.model.entity.product;

import com.customshop.back.model.entity.BasicDetails;
import com.customshop.back.model.entity.Detailed;
import com.customshop.back.model.entity.auditable.AuditableSession;
import com.customshop.back.model.entity.product.details.ProductInstanceDetails;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "PRODUCT_INSTANCES")
@EqualsAndHashCode(callSuper = true)
public class ProductInstance extends AuditableSession implements Detailed<ProductInstanceDetails> {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "PRODUCT_INSTANCE_ID")
    private UUID productInstanceId;

    @Type(type = "uuid-char")
    @Column(name = "PRODUCT_ID")
    private UUID productId;

    @Column(name = "PRODUCT_INSTANCE_COUNT")
    private BigInteger productInstanceCount;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCT_INSTANCE_ID")
    private List<ProductInstanceDetails> productInstanceDetails;

    @Override
    public List<ProductInstanceDetails> getDetails() {
        return this.productInstanceDetails;
    }

    @Override
    public void setDetails(List<BasicDetails> basicDetails) {
        this.productInstanceDetails = basicDetails.stream().map(details -> (ProductInstanceDetails) details)
                .collect(Collectors.toList());
    }

    @Override
    public UUID getPk() {
        return this.productInstanceId;
    }
}
