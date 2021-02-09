package com.customshop.back.model.repo;

import com.customshop.back.model.entity.CartRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends CrudRepository<CartRecord, Long> {

}
