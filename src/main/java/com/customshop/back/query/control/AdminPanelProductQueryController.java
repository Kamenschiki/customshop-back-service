package com.customshop.back.query.control;

import com.customshop.back.model.dto.query.res.GetUserDataResDto;
import com.customshop.back.query.service.AdminPanelQueryService;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/customshop/v1/admin")
public class AdminPanelProductQueryController {

    @Autowired
    private AdminPanelQueryService queryService;

    @ApiImplicitParam(name = "Authorization", value = "Authorization", paramType = "header", defaultValue = "Bearer_")
    @GetMapping(value = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetUserDataResDto> getUserData(@PathVariable(name = "id") UUID id) {
        return new ResponseEntity<>(queryService.getUserData(id), HttpStatus.OK);
    }
}
