package com.customshop.back.auth.control;

import com.customshop.back.auth.security.jwt.JwtAuthException;
import com.customshop.back.auth.security.jwt.JwtTokenProvider;
import com.customshop.back.auth.service.AuthenticationService;
import com.customshop.back.model.dao.UserDao;
import com.customshop.back.model.dto.auth.*;
import com.customshop.back.model.entity.auth.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customshop/v1/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserDao userDao;

    @ApiOperation(value = "Sign in with username", response = SignInResDto.class)
    @PostMapping(value = "/signInWithUsername", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SignInResDto> signInWithUsername(@RequestBody SignInWithUsernameReqDto signInReqDto) {
        try {
            String username = signInReqDto.getUsername();
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, signInReqDto.getPassword()));
            User user = userDao.findByName(username);

            String token = jwtTokenProvider.createToken(username, user.getRoles());

            return ResponseEntity.ok(new SignInResDto(user.getUserId().toString(), token));

        } catch (AuthenticationException e) {
            throw new JwtAuthException("Invalid username or password");
        }

    }

    @ApiOperation(value = "Sign in with email", response = SignInResDto.class)
    @PostMapping(value = "/signInWithEmail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SignInResDto> signInWithEmail(@RequestBody SignInWithEmailReqDto signInReqDto) {
        try {
            User user = userDao.findByEmail(signInReqDto.getEmail());
            String username = user.getName();
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, signInReqDto.getPassword()));

            String token = jwtTokenProvider.createToken(username, user.getRoles());

            return ResponseEntity.ok(new SignInResDto(user.getUserId().toString(), token));

        } catch (AuthenticationException e) {
            throw new JwtAuthException("Invalid username or password");
        }

    }

    @ApiOperation(value = "Sign up", response = SignUpResDto.class)
    @PostMapping(value = "/signUp", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SignUpResDto> signUp(@RequestBody SignUpReqDto signUpReqDto) {
        return ResponseEntity.ok(new SignUpResDto(authenticationService.userSignUp(signUpReqDto).toString()));
    }

}
