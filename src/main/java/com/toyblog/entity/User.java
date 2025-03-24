package com.toyblog.entity;

import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
public class User {
    public String id;
    private String password;
    public String nickname;
    public String email;
    public final Instant createdAt;

    public User(String id, String password, String nickname, String email ) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.createdAt = Instant.now();
    }
}
