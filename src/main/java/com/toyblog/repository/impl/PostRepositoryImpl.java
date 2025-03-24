package com.toyblog.repository.impl;

import com.toyblog.entity.Post;
import com.toyblog.exception.PostNotFoundException;
import com.toyblog.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PostRepositoryImpl implements PostRepository {
    List<Post> posts = new ArrayList<>();

    @Override
    public Post save(Post post) {
        posts.add(post);
        return post;
    }

    @Override
    public Post findById(UUID id) {
        return posts.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(() -> new PostNotFoundException("게시글을 찾을 수 없습니다."));
    }

    @Override
    public Post findByTitle(String title) {
        return posts.stream().filter(p -> p.getTitle().equals(title)).findFirst().orElseThrow(() -> new PostNotFoundException("게시글을 찾을 수 없습니다."));
    }

    @Override
    public Post findByAuthorId(String id) {
        return posts.stream().filter(p -> p.getAuthorId().equals(id)).findFirst().orElseThrow(() -> new PostNotFoundException("게시글을 찾을 수 없습니다."));
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public void delete(UUID id) {
        Post target = findById(id);
        posts.remove(target);
    }
}
