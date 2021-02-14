package com.customshop.back.model.dao;

import com.customshop.back.model.entity.product.Product;
import com.customshop.back.model.repo.product.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class ProductDao implements BasicDao<Product> {

    @Autowired
    private ProductRepo productRepo;

    public Product findByPk(UUID id) {
        Product product = productRepo.findById(id).orElseThrow(
                () -> new RuntimeException("404" + Product.class + "with id: " + id.toString() + " not found"));
        log.info("{} with id {} found", Product.class, id);
        return product;
    }

    public List<Product> findByPkIn(List<UUID> ids) {
        List<Product> productList = productRepo.findAllByProductIdIn(ids);
        log.info("{} where productId in {} found: {}", Product.class, ids.toString(), productList.size());
        return productList;
    }

}
