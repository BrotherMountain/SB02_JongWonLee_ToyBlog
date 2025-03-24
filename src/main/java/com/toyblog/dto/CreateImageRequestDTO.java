package com.toyblog.dto;

public record CreateImageRequestDTO(
        String originalName,
        String extension,
        byte[] bytes
) {
}
