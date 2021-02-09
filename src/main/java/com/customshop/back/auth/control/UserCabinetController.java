package com.customshop.back.auth.control;

import com.customshop.back.auth.service.UserService;
import com.customshop.back.model.dto.GetUserDataResDto;
import com.customshop.back.model.entity.User;
import com.customshop.back.auth.security.jwt.JwtAuthException;
import com.customshop.back.auth.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customshop/v1/user")
public class UserCabinetController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetUserDataResDto> getUserData(@RequestHeader(name = "Authorization") String accessToken) {

        String resolvedToken = jwtTokenProvider.resolveToken(accessToken);
        if (jwtTokenProvider.validateToken(resolvedToken)) {
            User result = userService.findByUsername(jwtTokenProvider.getUsername(resolvedToken));
            if (result == null) {
                throw new RuntimeException("404 User not found");
            }
            return new ResponseEntity<>(new GetUserDataResDto(result), HttpStatus.OK);
        } else {
            throw new JwtAuthException("JWT Token is expired");
        }
    }

}
