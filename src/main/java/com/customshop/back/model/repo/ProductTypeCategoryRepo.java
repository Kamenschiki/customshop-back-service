package com.customshop.back.model.repo;

import com.customshop.back.model.entity.ProductTypeCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeCategoryRepo extends CrudRepository<ProductTypeCategory, Long> {

}
