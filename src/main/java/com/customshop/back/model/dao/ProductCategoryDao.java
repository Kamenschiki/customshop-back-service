package com.customshop.back.model.dao;

import com.customshop.back.model.entity.product.ProductCategory;
import com.customshop.back.model.repo.product.ProductCategoryRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class ProductCategoryDao implements BasicDao<ProductCategory> {

    @Autowired
    private ProductCategoryRepo productCategoryRepo;

    @Override
    public ProductCategory findByPk(UUID id) {
        ProductCategory product = productCategoryRepo.findById(id).orElseThrow(
                () -> new RuntimeException("404" + ProductCategory.class + "with id: " + id.toString() + " not found"));
        log.info("{} with id {} found", ProductCategory.class, id);
        return product;
    }

    @Override
    public List<ProductCategory> findByPkIn(List<UUID> ids) {
        List<ProductCategory> productCategoryList = productCategoryRepo.findAllByProductCategoryIdIn(ids);
        log.info("{} where productCategoryId in {} found: {}", ProductCategory.class, ids.toString(),
                productCategoryList.size());
        return productCategoryList;
    }

}
