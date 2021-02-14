package com.customshop.back.command.service;

import com.customshop.back.model.dao.ProductInstanceDao;
import com.customshop.back.model.dto.command.req.ProductInstanceReqDto;
import com.customshop.back.model.entity.product.ProductInstance;
import com.customshop.back.model.entity.product.details.ProductInstanceDetails;
import com.customshop.back.model.mappers.product.ProductInstanceDtoToProductInstanceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminPanelProductInstanceCommandService extends
        AdminPanelCommandService<ProductInstance, ProductInstanceDetails, ProductInstanceDao, ProductInstanceReqDto, ProductInstanceDtoToProductInstanceMapper> {

    @Autowired
    private ProductInstanceDao productInstanceDao;
    private final ProductInstanceDtoToProductInstanceMapper productInstanceMapper = ProductInstanceDtoToProductInstanceMapper.INSTANCE;

    @Override
    protected ProductInstanceDao getDao() {
        return this.productInstanceDao;
    }

    @Override
    protected ProductInstanceDtoToProductInstanceMapper getMapper() {
        return this.productInstanceMapper;
    }

    @Override
    protected ProductInstanceDetails getDetails() {
        return new ProductInstanceDetails();
    }

}
