package com.customshop.back.command.service;

import com.customshop.back.model.dao.ProductDao;
import com.customshop.back.model.dto.command.req.ProductReqDto;
import com.customshop.back.model.entity.product.Product;
import com.customshop.back.model.entity.product.details.ProductDetails;
import com.customshop.back.model.mappers.product.ProductDtoToProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminPanelProductCommandService extends
        AdminPanelCommandService<Product, ProductDetails, ProductDao, ProductReqDto, ProductDtoToProductMapper> {

    @Autowired
    private ProductDao productDao;
    private final ProductDtoToProductMapper productMapper = ProductDtoToProductMapper.INSTANCE;

    @Override
    protected ProductDao getDao() {
        return this.productDao;
    }

    @Override
    protected ProductDtoToProductMapper getMapper() {
        return this.productMapper;
    }

    @Override
    protected ProductDetails getDetails() {
        return new ProductDetails();
    }

}
