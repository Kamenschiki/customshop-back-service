package com.customshop.back.model.mappers;

public interface BasicMapper<T, D> {

    T map(D source);

    void merge(D source, T target);

}
