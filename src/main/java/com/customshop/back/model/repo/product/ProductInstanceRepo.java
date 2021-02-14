package com.customshop.back.model.repo.product;

import com.customshop.back.model.entity.product.ProductInstance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductInstanceRepo extends CrudRepository<ProductInstance, UUID> {

    List<ProductInstance> findAllByProductInstanceIdIn(Iterable<UUID> ids);

}
