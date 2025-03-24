package com.toyblog.entity;

import lombok.Getter;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
public class Post {
    public final UUID id;
    public String title;
    public String content;
    public final String authorId;
    public List<String> tags;
    public final Instant createdAt;
    public Instant updatedAt;

    public Post(String title, String content, String authorId, List<String> tags) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.tags = tags;
        this.createdAt = Instant.now();
        this.updatedAt = this.createdAt;
    }
}
