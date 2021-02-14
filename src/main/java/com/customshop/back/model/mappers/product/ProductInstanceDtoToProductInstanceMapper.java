package com.customshop.back.model.mappers.product;

import com.customshop.back.model.dto.command.req.ProductInstanceReqDto;
import com.customshop.back.model.entity.product.ProductInstance;
import com.customshop.back.model.mappers.BasicMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProductInstanceDtoToProductInstanceMapper extends BasicMapper<ProductInstance, ProductInstanceReqDto> {

    ProductInstanceDtoToProductInstanceMapper INSTANCE = Mappers
            .getMapper(ProductInstanceDtoToProductInstanceMapper.class);

    @Override
    @Mapping(target = "productId", source = "productId")
    @Mapping(target = "productInstanceCount", source = "productInstanceCount")
    ProductInstance map(ProductInstanceReqDto source);

    @Override
    @Mapping(target = "productId", source = "productId")
    @Mapping(target = "productInstanceCount", source = "productInstanceCount")
    void merge(ProductInstanceReqDto source, @MappingTarget ProductInstance target);

}
