package com.app.controller;

import com.app.entity.dto.LoginDto;
import com.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping(value = "/api/authenticate")
public class AuthController {

    private  final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<LoginDto>> auth(@RequestBody LoginDto loginDto) {
        return CompletableFuture
                .supplyAsync(() -> {
                    log.info(loginDto.toString());
                    return this.service.saveUser(loginDto);
                })
                .thenApply(LoginDto::getFromUser)
                .thenApply(dto -> ResponseEntity.status(HttpStatus.OK).body(dto));
    }
}
