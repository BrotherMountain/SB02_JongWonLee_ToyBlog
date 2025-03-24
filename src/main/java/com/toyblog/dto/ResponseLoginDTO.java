package com.toyblog.dto;

public record ResponseLoginDTO(
        boolean success,
        String token
) {
}
