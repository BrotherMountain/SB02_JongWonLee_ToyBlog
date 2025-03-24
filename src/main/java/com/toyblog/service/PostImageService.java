package com.toyblog.service;

import com.toyblog.entity.PostImage;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface PostImageService {
    PostImage save(UUID postId, UUID imageId);

    void delete(UUID postId);

}
