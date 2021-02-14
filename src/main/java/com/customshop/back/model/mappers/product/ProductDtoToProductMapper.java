package com.customshop.back.model.mappers.product;

import com.customshop.back.model.dto.command.req.ProductReqDto;
import com.customshop.back.model.entity.product.Product;
import com.customshop.back.model.mappers.BasicMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProductDtoToProductMapper extends BasicMapper<Product, ProductReqDto> {

    ProductDtoToProductMapper INSTANCE = Mappers.getMapper(ProductDtoToProductMapper.class);

    @Override
    @Mapping(target = "productCategoryId", source = "productCategoryId")
    Product map(ProductReqDto source);

    @Override
    @Mapping(target = "productCategoryId", source = "productCategoryId")
    void merge(ProductReqDto source, @MappingTarget Product target);

}
