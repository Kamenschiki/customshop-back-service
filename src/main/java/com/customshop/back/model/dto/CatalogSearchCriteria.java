package com.customshop.back.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class CatalogSearchCriteria {
    private UUID productTypeCategoryId;
    private BigDecimal lowestPrice;
    private BigDecimal highestPrice;
    private Boolean hasSale;
}
