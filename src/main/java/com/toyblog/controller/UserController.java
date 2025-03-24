package com.toyblog.controller;

import com.toyblog.dto.*;
import com.toyblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseRegisterDTO> register(CreateUserRequestDTO requestDTO) {
        CreateUserResultDTO register = userService.register(requestDTO);
        return ResponseEntity.ok(new ResponseRegisterDTO(true, "회원 가입이 완료되었습니다."));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseLoginDTO> login(LoginRequestDTO requestDTO) {
        String token = userService.login(requestDTO);
        return ResponseEntity.ok(new ResponseLoginDTO(true, token));
    }


}
