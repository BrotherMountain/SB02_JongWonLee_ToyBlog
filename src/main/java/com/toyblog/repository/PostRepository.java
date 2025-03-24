package com.toyblog.repository;

import com.toyblog.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepository {
    Post save(Post post);

    Post findById(UUID id);

    Post findByTitle(String title);

    Post findByAuthorId(String id);

    List<Post> findAll();

//    Post findByTags(List<String> tags);

    void delete(UUID id);

}
