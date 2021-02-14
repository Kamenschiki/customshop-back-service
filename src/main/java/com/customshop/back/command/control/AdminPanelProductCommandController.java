package com.customshop.back.command.control;

import com.customshop.back.command.service.AdminPanelProductCommandService;
import com.customshop.back.model.dto.command.req.ProductReqDto;
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
public class AdminPanelProductCommandController {

    @Autowired
    private AdminPanelProductCommandService adminPanelUserCommandService;

    @ApiImplicitParam(name = "Authorization", value = "Authorization", paramType = "header", defaultValue = "Bearer_")
    @PostMapping(value = "/products/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createProducts(@RequestBody List<ProductReqDto> productReqDtos) {
        adminPanelUserCommandService.createDetailedList(productReqDtos);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiImplicitParam(name = "Authorization", value = "Authorization", paramType = "header", defaultValue = "Bearer_")
    @PutMapping(value = "/products/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProducts(@RequestBody List<ProductReqDto> productReqDtos) {
        adminPanelUserCommandService.updateDetailedList(productReqDtos);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiImplicitParam(name = "Authorization", value = "Authorization", paramType = "header", defaultValue = "Bearer_")
    @PutMapping(value = "/products/updateAudStatus", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateAudStatusProducts(@RequestBody List<UpdateAudStatusReqDto> updateAudStatusReqDtos) {
        adminPanelUserCommandService.updateAudStatusList(updateAudStatusReqDtos);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
