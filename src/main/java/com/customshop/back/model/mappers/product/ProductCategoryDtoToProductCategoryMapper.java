package com.customshop.back.model.mappers.product;

import com.customshop.back.model.dto.command.req.ProductCategoryReqDto;
import com.customshop.back.model.entity.product.ProductCategory;
import com.customshop.back.model.mappers.BasicMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProductCategoryDtoToProductCategoryMapper extends BasicMapper<ProductCategory, ProductCategoryReqDto> {

    ProductCategoryDtoToProductCategoryMapper INSTANCE = Mappers
            .getMapper(ProductCategoryDtoToProductCategoryMapper.class);

    @Override
    @Mapping(target = "parentProductCategoryId", source = "parentProductCategoryId")
    ProductCategory map(ProductCategoryReqDto source);

    @Override
    @Mapping(target = "parentProductCategoryId", source = "parentProductCategoryId")
    void merge(ProductCategoryReqDto source, @MappingTarget ProductCategory target);

}
