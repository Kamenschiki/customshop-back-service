package com.customshop.back.model.dto.command.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigInteger;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductInstanceReqDto extends DetailedReqBasicDto {

    private UUID productInstanceId;
    private UUID productId;
    private BigInteger productInstanceCount;

    @Override
    public UUID getPk() {
        return productInstanceId;
    }

}
