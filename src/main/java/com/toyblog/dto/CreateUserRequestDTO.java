package com.toyblog.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateUserRequestDTO(
        @NotBlank String id,
        @NotBlank String password,
        @NotBlank String nickname,
        String email
) {
}
