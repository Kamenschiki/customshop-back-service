package com.customshop.back.query.control;

import com.customshop.back.model.dto.query.rec.GetFilteredUserListReqDto;
import com.customshop.back.model.dto.query.res.GetFilteredUserListResDto;
import com.customshop.back.model.dto.query.res.GetUserDataResDto;
import com.customshop.back.query.service.AdminPanelQueryService;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/customshop/v1/admin")
public class AdminPanelUserQueryController {

    @Autowired
    private AdminPanelQueryService queryService;

    @ApiImplicitParam(name = "Authorization", value = "Authorization", paramType = "header", defaultValue = "Bearer_")
    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetUserDataResDto> getUserData(@PathVariable(name = "id") UUID id) {
        return new ResponseEntity<>(queryService.getUserData(id), HttpStatus.OK);
    }

    @ApiImplicitParam(name = "Authorization", value = "Authorization", paramType = "header", defaultValue = "Bearer_")
    @PostMapping(value = "/users/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GetFilteredUserListResDto>> getFilteredUserList(
            @RequestBody GetFilteredUserListReqDto getFilteredUserListReqDto) {
        return new ResponseEntity<>(queryService.getFilteredUsersList(getFilteredUserListReqDto), HttpStatus.OK);
    }
}
