package com.customshop.back.command.control;

import com.customshop.back.command.service.AdminPanelUserCommandService;
import com.customshop.back.model.dto.command.req.UpdateAudStatusReqDto;
import com.customshop.back.model.dto.command.req.UserReqDto;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customshop/v1/admin")
public class AdminPanelUserCommandController {

    @Autowired
    private AdminPanelUserCommandService adminPanelUserCommandService;

    @ApiImplicitParam(name = "Authorization", value = "Authorization", paramType = "header", defaultValue = "Bearer_")
    @PostMapping(value = "/users/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody List<UserReqDto> createUserReqDtos) {
        adminPanelUserCommandService.createDetailedList(createUserReqDtos);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiImplicitParam(name = "Authorization", value = "Authorization", paramType = "header", defaultValue = "Bearer_")
    @PutMapping(value = "/users/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUser(@RequestBody List<UserReqDto> userReqDtos) {
        adminPanelUserCommandService.updateDetailedList(userReqDtos);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiImplicitParam(name = "Authorization", value = "Authorization", paramType = "header", defaultValue = "Bearer_")
    @PutMapping(value = "/users/updateAudStatus", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUserAudStatus(@RequestBody List<UpdateAudStatusReqDto> updateAudStatusReqDtos) {
        adminPanelUserCommandService.updateAudStatusList(updateAudStatusReqDtos);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
