package com.toyblog.service;

import com.toyblog.dto.CreateUserRequestDTO;
import com.toyblog.dto.CreateUserResultDTO;
import com.toyblog.dto.LoginRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    CreateUserResultDTO register(CreateUserRequestDTO requestDTO);

    String login(LoginRequestDTO requestDTO);

    boolean existsById(String id);
}
