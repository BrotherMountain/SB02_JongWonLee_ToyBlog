package com.toyblog.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
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

//    public String update(String replaceId, String replacePassword, String replaceNickname, String replaceEmail) {
//        if (replaceId != null) {
//            this.id = replaceId;
//        }
//        if (replacePassword != null) {
//            this.password = password;
//        }
//        if (replaceNickname != null) {
//            this.nickname = replaceNickname;
//        }
//        if (replaceEmail != null) {
//            this.email = replaceEmail;
//        }
//        return this.id;
//    }

}
