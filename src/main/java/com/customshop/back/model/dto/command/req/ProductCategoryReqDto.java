package com.customshop.back.model.dto.command.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductCategoryReqDto extends DetailedReqBasicDto {

    private UUID productCategoryId;
    private UUID parentProductCategoryId;

    @Override
    public UUID getPk() {
        return productCategoryId;
    }
}
