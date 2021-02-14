package com.customshop.back.model.repo.product;

import com.customshop.back.model.entity.product.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepo extends CrudRepository<Product, UUID> {

    List<Product> findAllByProductIdIn(Iterable<UUID> ids);

}
