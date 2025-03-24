package com.toyblog.service.impl;

import com.toyblog.dto.CreateUserRequestDTO;
import com.toyblog.dto.CreateUserResultDTO;
import com.toyblog.dto.LoginRequestDTO;
import com.toyblog.entity.User;
import com.toyblog.exception.DuplicateUserException;
import com.toyblog.exception.InvalidPasswordException;
import com.toyblog.exception.UserNotFoundException;
import com.toyblog.repository.UserRepository;
import com.toyblog.service.UserService;
import com.toyblog.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Override
    public CreateUserResultDTO register(CreateUserRequestDTO requestDTO) {
        String hashedPassword = BCrypt.hashpw(requestDTO.password(), BCrypt.gensalt());

        if (!existsById(requestDTO.id())) {
            User user = new User(requestDTO.id(), hashedPassword, requestDTO.nickname(), requestDTO.email());
            userRepository.save(user);
            return CreateUserResultDTO.result(user);

        } else {
            throw new DuplicateUserException("중복된 유저가 존재합니다.");
        }
    }

    @Override
    public String login(LoginRequestDTO requestDTO) {
        User user = userRepository.findById(requestDTO.id());

        if (!BCrypt.checkpw(requestDTO.password(), user.getPassword())) {
            throw new InvalidPasswordException("비밀번호가 일치하지 않습니다.");
        }

        return jwtUtil.generateToken(user.getId());
    }

    @Override
    public boolean existsById(String id) {
        try {
            User user = userRepository.findById(id);
            return true;
        } catch (UserNotFoundException e) {
            return false;
        }
    }
}
