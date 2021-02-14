package com.customshop.back.model.dao;

import com.customshop.back.model.entity.product.Product;
import com.customshop.back.model.entity.product.ProductInstance;
import com.customshop.back.model.repo.product.ProductInstanceRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class ProductInstanceDao implements BasicDao<ProductInstance> {

    @Autowired
    private ProductInstanceRepo productInstanceRepo;

    public ProductInstance findByPk(UUID id) {
        ProductInstance productInstance = productInstanceRepo.findById(id).orElseThrow(
                () -> new RuntimeException("404" + Product.class + "with id: " + id.toString() + " not found"));
        log.info("{} with id {} found", Product.class, id);
        return productInstance;
    }

    public List<ProductInstance> findByPkIn(List<UUID> ids) {
        List<ProductInstance> productInstanceList = productInstanceRepo.findAllByProductInstanceIdIn(ids);
        log.info("{} where productId in {} found: {}", ProductInstance.class, ids.toString(),
                productInstanceList.size());
        return productInstanceList;
    }
}
