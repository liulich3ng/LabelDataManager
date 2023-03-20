package com.liulich3ng.controller;

import com.liulich3ng.dto.response.AuthenticationDTO;
import com.liulich3ng.dto.request.LoginDTO;
import com.liulich3ng.dto.request.RegisterDTO;
import com.liulich3ng.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationDTO> register(@RequestBody @Valid RegisterDTO registerBody) {
        String token = authenticationService.register(
                registerBody.getUsername(),
                registerBody.getPassword(),
                registerBody.getPhone(),
                registerBody.getCode());
        return ResponseEntity.ok(new AuthenticationDTO(token));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationDTO> login(@RequestBody @Valid LoginDTO loginBody) {
        String token = authenticationService.login(loginBody.getUsername(), loginBody.getPassword());
        return ResponseEntity.ok(new AuthenticationDTO(token));
    }


}
