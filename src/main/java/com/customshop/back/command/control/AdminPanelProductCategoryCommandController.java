package com.customshop.back.command.control;

import com.customshop.back.command.service.AdminPanelProductCategoryCommandService;
import com.customshop.back.model.dto.command.req.ProductCategoryReqDto;
import com.customshop.back.model.dto.command.req.UpdateAudStatusReqDto;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customshop/v1/admin")
public class AdminPanelProductCategoryCommandController {

    @Autowired
    private AdminPanelProductCategoryCommandService adminPanelProductCategoryCommandService;

    @ApiImplicitParam(name = "Authorization", value = "Authorization", paramType = "header", defaultValue = "Bearer_")
    @PostMapping(value = "/productCategories/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createProductCategories(@RequestBody List<ProductCategoryReqDto> productCategoryReqDtos) {
        adminPanelProductCategoryCommandService.createDetailedList(productCategoryReqDtos);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiImplicitParam(name = "Authorization", value = "Authorization", paramType = "header", defaultValue = "Bearer_")
    @PutMapping(value = "/productCategories/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProductCategories(@RequestBody List<ProductCategoryReqDto> productCategoryReqDtos) {
        adminPanelProductCategoryCommandService.updateDetailedList(productCategoryReqDtos);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiImplicitParam(name = "Authorization", value = "Authorization", paramType = "header", defaultValue = "Bearer_")
    @PutMapping(value = "/productCategories/updateAudStatus", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteProductCategories(@RequestBody List<UpdateAudStatusReqDto> updateAudStatusReqDtos) {
        adminPanelProductCategoryCommandService.updateAudStatusList(updateAudStatusReqDtos);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
