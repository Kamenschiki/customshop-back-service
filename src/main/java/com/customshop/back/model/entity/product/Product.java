package com.customshop.back.model.entity.product;

import com.customshop.back.model.entity.BasicDetails;
import com.customshop.back.model.entity.Detailed;
import com.customshop.back.model.entity.auditable.AuditableSession;
import com.customshop.back.model.entity.product.details.ProductDetails;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Entity()
@Table(name = "PRODUCTS")
@EqualsAndHashCode(callSuper = true)
public class Product extends AuditableSession implements Detailed<ProductDetails> {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "PRODUCT_ID")
    private UUID productId;

    @Type(type = "uuid-char")
    @Column(name = "PRODUCT_CATEGORY_ID")
    private UUID productCategoryId;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCT_ID")
    private List<ProductDetails> productDetails;

    @Override
    public List<ProductDetails> getDetails() {
        return this.productDetails;
    }

    @Override
    public void setDetails(List<BasicDetails> basicDetails) {
        this.productDetails = basicDetails.stream().map(details -> (ProductDetails) details)
                .collect(Collectors.toList());
    }

    @Override
    public UUID getPk() {
        return this.productId;
    }
}
