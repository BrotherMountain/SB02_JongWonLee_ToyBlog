package com.toyblog.dto;

import com.toyblog.entity.User;
import lombok.Builder;

@Builder
public record AuthorDTO(
        String id,
        String nickname
) {
    public static AuthorDTO create(User user) {
        return AuthorDTO.builder()
                .id(user.getId())
                .nickname(user.getNickname()).build();
    }
}
