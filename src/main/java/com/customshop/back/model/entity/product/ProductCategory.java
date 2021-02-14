package com.customshop.back.model.entity.product;

import com.customshop.back.model.entity.BasicDetails;
import com.customshop.back.model.entity.Detailed;
import com.customshop.back.model.entity.auditable.AuditableSession;
import com.customshop.back.model.entity.product.details.ProductCategoryDetails;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "PRODUCT_CATEGORIES")
@EqualsAndHashCode(callSuper = true)
public class ProductCategory extends AuditableSession implements Detailed<ProductCategoryDetails> {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "PRODUCT_CATEGORY_ID")
    private UUID productCategoryId;

    @Type(type = "uuid-char")
    @Column(name = "PARENT_PRODUCT_CATEGORY_ID")
    private UUID parentProductCategoryId;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCT_CATEGORY_ID")
    private List<ProductCategoryDetails> productCategoryDetails;

    @Override
    public List<ProductCategoryDetails> getDetails() {
        return this.productCategoryDetails;
    }

    @Override
    public void setDetails(List<BasicDetails> basicDetails) {
        this.productCategoryDetails = basicDetails.stream().map(details -> (ProductCategoryDetails) details)
                .collect(Collectors.toList());
    }

    @Override
    public UUID getPk() {
        return this.productCategoryId;
    }
}
