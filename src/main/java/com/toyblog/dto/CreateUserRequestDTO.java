package com.toyblog.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateUserRequestDTO(
        @NotBlank @Size(min=6,max=30) String id,
        @NotBlank
        @Size(min=12,max=50)
        @Pattern(regexp = "^(?=(.*[a-zA-Z]){2,})(?=(.*\\d){2,})(?=(.*[!@#$%^&*]){2,}).{12,50}$")
        String password,
        @NotBlank @Email String email,
        @NotBlank @Size(max=50) String nickname
) {
}
