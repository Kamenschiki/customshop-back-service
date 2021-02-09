package com.customshop.back.query.control;

import com.customshop.back.model.dto.GetUserDataResDto;
import com.customshop.back.model.entity.User;
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
public class AdminPanelQueryController {

    @Autowired
    private AdminPanelQueryService queryService;

    @ApiImplicitParam(name = "Authorization", value = "Authorization", paramType = "header", defaultValue = "Bearer_")
    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetUserDataResDto> getUserData(@PathVariable(name = "id") UUID id) {
        User result = queryService.findUserByUserId(id);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(new GetUserDataResDto(result), HttpStatus.OK);

    }
}
