package com.toyblog.entity;

import lombok.Getter;

import java.nio.file.Path;
import java.time.Instant;
import java.util.UUID;

@Getter
public class Image {
    public final UUID id;
    public Path path;
    public String originalName;
    public String extension;
    public Long size;
    public byte[] bytes;
    public final Instant uploadedAt;

    public Image( Path path, String originalName, String extension, Long size, byte[] bytes) {
        this.id = UUID.randomUUID();
        this.path = path;
        this.originalName = originalName;
        this.extension = extension;
        this.size = size;
        this.bytes = bytes;
        this.uploadedAt = Instant.now();
    }
}
