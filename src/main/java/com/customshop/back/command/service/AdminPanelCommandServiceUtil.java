package com.customshop.back.command.service;

import com.customshop.back.config.ApplicationConstants;
import com.customshop.back.model.dto.command.req.DetailedReqBasicDto;
import com.customshop.back.model.dto.command.req.UpdateAudStatusReqDto;
import com.customshop.back.model.entity.BasicDetails;
import com.customshop.back.model.entity.auditable.AuditableSession;
import com.customshop.back.model.entity.auditable.AuditableStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class AdminPanelCommandServiceUtil {

    static List<BasicDetails> createDetailsList(DetailedReqBasicDto detailedReqBasicDto,
            Supplier<? extends BasicDetails> supplier) {
        List<BasicDetails> basicDetailsList = new ArrayList<>();
        detailedReqBasicDto.getDetailsToCreateByType().forEach((detailType, detailTextList) -> {
            detailTextList.forEach(detailText -> {
                BasicDetails basicDetails = supplier.get();
                basicDetails.setDetailType(detailType);
                basicDetails.setDetailText(detailText);
                basicDetailsList.add(basicDetails);
            });
        });
        return basicDetailsList;
    }

    static List<BasicDetails> updateDetailsList(List<? extends BasicDetails> basicDetailsFromDb,
            DetailedReqBasicDto detailedReqBasicDto, Supplier<? extends BasicDetails> supplier) {
        List<BasicDetails> updatedBasicDetailsList = createDetailsList(detailedReqBasicDto, supplier);

        basicDetailsFromDb.stream()
                .filter(pd -> detailedReqBasicDto.getDetailIdsToDelete().contains(pd.getPrimaryKey()))
                .peek(pd -> pd.setAuditableStatus(AuditableStatus.DELETED))
                .peek(pd -> pd.setAudStatusUpdateReason(ApplicationConstants.DEFAULT_AUDITABLE_STATUS_CHANGE_REASON))
                .forEach(updatedBasicDetailsList::add);

        basicDetailsFromDb.stream()
                .filter(pd -> detailedReqBasicDto.getDetailsToUpdateById().containsKey(pd.getPrimaryKey()))
                .peek(pd -> pd.setDetailText(detailedReqBasicDto.getDetailsToUpdateById().get(pd.getPrimaryKey())))
                .forEach(updatedBasicDetailsList::add);

        return updatedBasicDetailsList;
    }

    static void updateAudStatus(AuditableSession auditable, UpdateAudStatusReqDto updateAudStatusReqDto) {
        auditable.setAuditableStatus(updateAudStatusReqDto.getAuditableStatus());
        auditable.setAudStatusUpdateReason(updateAudStatusReqDto.getAudStatusUpdateReason());
    }

}
