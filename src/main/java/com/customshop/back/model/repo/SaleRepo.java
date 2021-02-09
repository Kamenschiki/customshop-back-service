package com.customshop.back.model.repo;

import com.customshop.back.model.entity.Sale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepo extends CrudRepository<Sale, Long> {

}
