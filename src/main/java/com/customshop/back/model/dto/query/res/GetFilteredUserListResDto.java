package com.customshop.back.model.dto.query.res;

import com.customshop.back.model.dto.query.rec.Paginated;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class GetFilteredUserListResDto extends Paginated {
    private UUID userId;
    private String userName;
}
