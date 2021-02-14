package com.customshop.back.command.service;

import com.customshop.back.model.dao.BasicDao;
import com.customshop.back.model.dto.command.req.DetailedReqBasicDto;
import com.customshop.back.model.dto.command.req.UpdateAudStatusReqDto;
import com.customshop.back.model.entity.BasicDetails;
import com.customshop.back.model.entity.Detailed;
import com.customshop.back.model.entity.auditable.AuditableSession;
import com.customshop.back.model.mappers.BasicMapper;
import com.customshop.back.model.utils.PersistAuditEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.customshop.back.command.service.AdminPanelCommandServiceUtil.*;

@Slf4j
@Service
public abstract class AdminPanelCommandService<T extends AuditableSession & Detailed<DT>, DT extends BasicDetails, DA extends BasicDao<T>, DTO extends DetailedReqBasicDto, M extends BasicMapper<T, DTO>> {

    protected abstract DT getDetails();

    protected abstract DA getDao();

    protected abstract M getMapper();

    @Autowired
    private PersistAuditEntityService persistEntityService;

    public void createDetailedList(List<DTO> detailedReqBasicDtos) {
        List<Object> entitiesToUpsert = new ArrayList<>();

        detailedReqBasicDtos.forEach(detailedReqBasicDto -> {
            T entity = this.getMapper().map(detailedReqBasicDto);
            entity.setDetails(createDetailsList(detailedReqBasicDto, this::getDetails));
            entitiesToUpsert.add(entity);
        });

        persistEntityService.upsertAll(entitiesToUpsert);
        log.info("Products created: {}", entitiesToUpsert.size());
    }

    public void updateDetailedList(List<DTO> detailedReqBasicDtos) {
        List<Object> entitiesToUpsert = new ArrayList<>();

        List<T> entitiesFormDb = getDao()
                .findByPkIn(detailedReqBasicDtos.stream().map(DetailedReqBasicDto::getPk).collect(Collectors.toList()));

        entitiesFormDb.forEach(entityFromDb -> detailedReqBasicDtos.stream()
                .filter(detailedReqDto -> detailedReqDto.getPk().equals(entityFromDb.getPk())).findAny()
                .ifPresent(detailedReqDto -> {
                    getMapper().merge(detailedReqDto, entityFromDb);
                    entityFromDb
                            .setDetails(updateDetailsList(entityFromDb.getDetails(), detailedReqDto, this::getDetails));
                }));

        persistEntityService.upsertAll(entitiesToUpsert);
        log.info("Products updated: {}", detailedReqBasicDtos.size());
    }

    public void updateAudStatusList(List<UpdateAudStatusReqDto> updateAudStatusReqDtos) {
        List<Object> entitiesToUpsert = new ArrayList<>();

        List<T> entities = getDao().findByPkIn(
                updateAudStatusReqDtos.stream().map(UpdateAudStatusReqDto::getPk).collect(Collectors.toList()));

        entities.forEach(entity -> updateAudStatusReqDtos.stream()
                .filter(updateAudStatusReqDto -> updateAudStatusReqDto.getPk().equals(entity.getPk())).findAny()
                .ifPresent(updateAudStatusReqDto -> updateAudStatus(entity, updateAudStatusReqDto)));

        persistEntityService.upsertAll(entitiesToUpsert);
        log.info("Products status updated: {}", updateAudStatusReqDtos.size());
    }

}
