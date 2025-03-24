package com.toyblog.service.impl;

import com.toyblog.entity.PostImage;
import com.toyblog.repository.ImageRepository;
import com.toyblog.repository.PostImageRepository;
import com.toyblog.service.PostImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostImageServiceImpl implements PostImageService {
    private final PostImageRepository postImageRepository;
    private final ImageRepository imageRepository;

    @Override
    public PostImage save(UUID postId, UUID imageId) {
        PostImage postImage = new PostImage(postId, imageId);
        postImageRepository.save(postImage);
        return postImage;
    }

    @Override
    public void delete(UUID postId) {
        PostImage target = postImageRepository.findByPostId(postId);
        if (target != null) {
            postImageRepository.delete(target.getId());
            imageRepository.delete(target.getImageId());
        }
    }
}
