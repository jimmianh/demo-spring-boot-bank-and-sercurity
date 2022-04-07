package com.javamaster.springsecurityjwt.controller;

import javax.validation.Valid;

import com.javamaster.springsecurityjwt.entity.RoleEntity;
import com.javamaster.springsecurityjwt.exception.ExceptionAuthentication;
import com.javamaster.springsecurityjwt.repository.RoleEntityRepository;
import com.javamaster.springsecurityjwt.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javamaster.springsecurityjwt.config.jwt.JwtProvider;
import com.javamaster.springsecurityjwt.entity.UserEntity;
import com.javamaster.springsecurityjwt.request.AuthRequest;
import com.javamaster.springsecurityjwt.request.RegistrationRequest;
import com.javamaster.springsecurityjwt.response.AuthResponse;
import com.javamaster.springsecurityjwt.service.UserService;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private UserEntityRepository userEntityRepository;

    ExceptionAuthentication exceptionAuthentication = new ExceptionAuthentication();

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        UserEntity userName = userEntityRepository.findByLogin(registrationRequest.getLogin());
        if (userName != null) {
            return exceptionAuthentication.registerError(exceptionAuthentication);
        } else {
            userService.saveUser(registrationRequest);
            return "OK";
        }
    }


    @PostMapping("/auth")
    public String auth(@RequestBody @Valid AuthRequest request) {
        if (request.getLogin() == null || request.getPassword() == null) {
            return exceptionAuthentication.loginError(exceptionAuthentication);
        } else {
            UserEntity userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
            String token = jwtProvider.generateToken(userEntity.getLogin());
//			return new AuthResponse(token);
            return token;
        }
    }
}
