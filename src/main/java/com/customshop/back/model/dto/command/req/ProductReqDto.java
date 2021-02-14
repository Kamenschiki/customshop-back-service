package com.customshop.back.model.dto.command.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductReqDto extends DetailedReqBasicDto {

    private UUID productId;
    private UUID productCategoryId;

    @Override
    public UUID getPk() {
        return productId;
    }
}
