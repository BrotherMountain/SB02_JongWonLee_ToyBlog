package com.toyblog.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateUserRequestDTO(
        String id,
        String password,
        String nickname,
        String email
) {
}
