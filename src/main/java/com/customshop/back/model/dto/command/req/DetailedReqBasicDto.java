package com.customshop.back.model.dto.command.req;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public abstract class DetailedReqBasicDto {

    private Map<String, List<String>> detailsToCreateByType;
    private Map<UUID, String> detailsToUpdateById;
    private List<UUID> detailIdsToDelete;

    public abstract UUID getPk();

}
