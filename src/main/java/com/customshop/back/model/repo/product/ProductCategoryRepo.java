package com.customshop.back.model.repo.product;

import com.customshop.back.model.entity.product.ProductCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductCategoryRepo extends CrudRepository<ProductCategory, UUID> {

    List<ProductCategory> findAllByProductCategoryIdIn(Iterable<UUID> ids);

}
