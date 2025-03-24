package com.toyblog.controller;

import com.toyblog.dto.*;
import com.toyblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private String token = null;

    @PostMapping("/register")
    public ResponseEntity<ResponseRegisterDTO> register(@RequestBody CreateUserRequestDTO requestDTO) {
        CreateUserResultDTO register = userService.register(requestDTO);
        return ResponseEntity.ok(new ResponseRegisterDTO(true, "회원 가입이 완료되었습니다."));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseLoginDTO> login(@RequestBody LoginRequestDTO requestDTO) {
        String token = userService.login(requestDTO);
        this.token = token;
        return ResponseEntity.ok(new ResponseLoginDTO(true, token));
    }


}
