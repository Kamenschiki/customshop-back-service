package com.customshop.back.model.dao;

import java.util.List;
import java.util.UUID;

public interface BasicDao<T> {

    T findByPk(UUID pk);

    List<T> findByPkIn(List<UUID> pks);

}
