package com.customshop.back.command.service;

import com.customshop.back.model.dao.ProductCategoryDao;
import com.customshop.back.model.dto.command.req.ProductCategoryReqDto;
import com.customshop.back.model.entity.product.ProductCategory;
import com.customshop.back.model.entity.product.details.ProductCategoryDetails;
import com.customshop.back.model.mappers.product.ProductCategoryDtoToProductCategoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminPanelProductCategoryCommandService extends
        AdminPanelCommandService<ProductCategory, ProductCategoryDetails, ProductCategoryDao, ProductCategoryReqDto, ProductCategoryDtoToProductCategoryMapper> {

    @Autowired
    private ProductCategoryDao productCategoryDao;
    private final ProductCategoryDtoToProductCategoryMapper productCategoryMapper = ProductCategoryDtoToProductCategoryMapper.INSTANCE;

    @Override
    protected ProductCategoryDao getDao() {
        return productCategoryDao;
    }

    @Override
    protected ProductCategoryDtoToProductCategoryMapper getMapper() {
        return productCategoryMapper;
    }

    @Override
    protected ProductCategoryDetails getDetails() {
        return new ProductCategoryDetails();
    }

}
