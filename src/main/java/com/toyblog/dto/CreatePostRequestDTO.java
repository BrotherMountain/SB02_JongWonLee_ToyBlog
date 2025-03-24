package com.toyblog.dto;

import java.util.List;

public record CreatePostRequestDTO(
        String title,
        String content,
        String authorId,
        List<String> tags
) {
}
