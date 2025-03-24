package com.toyblog.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PostImage {
    public final UUID id;
    public UUID postId;
    public UUID imageId;

    public PostImage(UUID postId, UUID imageId) {
        this.id = UUID.randomUUID();
        this.postId = postId;
        this.imageId = imageId;
    }
}
