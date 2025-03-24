package com.toyblog.repository.impl;

import com.toyblog.entity.PostImage;
import com.toyblog.exception.PostImageNotFoundException;
import com.toyblog.repository.PostImageRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class PostImageRepositoryImpl implements PostImageRepository {
    List<PostImage> postImageList = new ArrayList<>();

    @Override
    public PostImage save(PostImage postImage) {
        postImageList.add(postImage);
        return postImage;
    }

    @Override
    public PostImage findById(UUID id) {
        return postImageList.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(() -> new PostImageNotFoundException("등록된 이미지가 없습니다."));
    }

    @Override
    public PostImage findByPostId(UUID id) {
        return postImageList.stream().filter(p -> p.getPostId().equals(id)).findFirst().orElseThrow(() -> new PostImageNotFoundException("등록된 이미지가 없습니다."));
    }

    @Override
    public PostImage findByImageId(UUID id) {
        return postImageList.stream().filter(p -> p.getImageId().equals(id)).findFirst().orElseThrow(() -> new PostImageNotFoundException("등록된 이미지가 없습니다."));
    }

    @Override
    public void update(UUID id,UUID replaceId) {
        PostImage target = findById(id);
        target.setImageId(replaceId);
    }

    @Override
    public void delete(UUID id) {
        PostImage target = findById(id);
        postImageList.remove(target);
    }
}
