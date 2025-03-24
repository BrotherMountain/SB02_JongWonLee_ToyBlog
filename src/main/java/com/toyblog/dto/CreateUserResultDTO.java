package com.toyblog.dto;

public record CreateUserResultDTO(
        String id,
        String nickname,
        String email
) {
}
