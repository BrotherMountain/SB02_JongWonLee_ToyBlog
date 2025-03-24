package com.toyblog.repository;

import com.toyblog.entity.PostImage;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostImageRepository {
    PostImage save(PostImage postImage);

    PostImage findById(UUID id);

    void update(UUID id);

    void delete(UUID id);
}
