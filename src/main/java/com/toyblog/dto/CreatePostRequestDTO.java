package com.toyblog.dto;

import java.util.List;

public record CreatePostRequestDTO(
        String title,
        String content,
        List<String> tags
) {
}
