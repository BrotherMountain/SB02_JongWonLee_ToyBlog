package com.toyblog.dto;

import com.toyblog.entity.User;
import lombok.Builder;

@Builder
public record CreateUserResultDTO(
        String id,
        String nickname,
        String email
) {
    public static CreateUserResultDTO result(User user) {
        return CreateUserResultDTO.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .build();
    }
}
