package com.toyblog.entity;

import lombok.Getter;

import java.util.UUID;

@Getter
public class PostImage {
    public UUID id;
    public UUID postId;
    public UUID imageId;

    public PostImage(UUID id, UUID postId, UUID imageId) {
        this.id = id;
        this.postId = postId;
        this.imageId = imageId;
    }
}
