package com.customshop.back.command.control;

import com.customshop.back.command.service.AdminPanelCommandService;
import com.customshop.back.model.dto.GetUserDataResDto;
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
public class AdminPanelCommandController {

    @Autowired
    private AdminPanelCommandService adminPanelCommandService;

    @ApiImplicitParam(name = "Authorization", value = "Authorization", paramType = "header", defaultValue = "Bearer_")
    @GetMapping(value = "/users/{id}/activate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetUserDataResDto> activateUser(@PathVariable(name = "id") UUID id) {
        adminPanelCommandService.activateUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiImplicitParam(name = "Authorization", value = "Authorization", paramType = "header", defaultValue = "Bearer_")
    @GetMapping(value = "/users/{id}/inactivate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetUserDataResDto> inactivateUser(@PathVariable(name = "id") UUID id) {
        adminPanelCommandService.inactivateUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiImplicitParam(name = "Authorization", value = "Authorization", paramType = "header", defaultValue = "Bearer_")
    @GetMapping(value = "/users/{id}/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetUserDataResDto> deleteUser(@PathVariable(name = "id") UUID id) {
        adminPanelCommandService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
