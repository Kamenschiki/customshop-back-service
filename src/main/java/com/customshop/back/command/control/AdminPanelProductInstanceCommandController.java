package com.customshop.back.command.control;

import com.customshop.back.command.service.AdminPanelProductInstanceCommandService;
import com.customshop.back.model.dto.command.req.ProductInstanceReqDto;
import com.customshop.back.model.dto.command.req.UpdateAudStatusReqDto;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customshop/v1/admin/productInstances")
public class AdminPanelProductInstanceCommandController {

    @Autowired
    private AdminPanelProductInstanceCommandService adminPanelProductInstanceCommandService;

    @ApiImplicitParam(name = "Authorization", value = "Authorization", paramType = "header", defaultValue = "Bearer_")
    @PostMapping(value = "/productInstances/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createProductInstance(@RequestBody List<ProductInstanceReqDto> productInstanceReqDtos) {
        adminPanelProductInstanceCommandService.createDetailedList(productInstanceReqDtos);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiImplicitParam(name = "Authorization", value = "Authorization", paramType = "header", defaultValue = "Bearer_")
    @PutMapping(value = "/productInstances/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProductInstance(@RequestBody List<ProductInstanceReqDto> productInstanceReqDtos) {
        adminPanelProductInstanceCommandService.updateDetailedList(productInstanceReqDtos);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiImplicitParam(name = "Authorization", value = "Authorization", paramType = "header", defaultValue = "Bearer_")
    @PutMapping(value = "/productInstances/updateAudStatus", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteProductInstance(@RequestBody List<UpdateAudStatusReqDto> updateAudStatusReqDtos) {
        adminPanelProductInstanceCommandService.updateAudStatusList(updateAudStatusReqDtos);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
