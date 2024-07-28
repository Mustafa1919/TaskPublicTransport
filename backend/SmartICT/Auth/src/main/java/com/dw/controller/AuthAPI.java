package com.dw.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthAPI {

    @PostMapping("/signUp")
    public ResponseEntity<AuthResponse> signUp(@RequestBody SignUpRequest signUpRequest){

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){

    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestParam String userName){

    }
}
