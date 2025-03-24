package com.toyblog.service;

import com.toyblog.dto.CreatePostRequestDTO;
import com.toyblog.dto.DeletePostRequestDTO;
import com.toyblog.dto.FindPostResultDTO;
import com.toyblog.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface PostService {
    Post write(String token, CreatePostRequestDTO requestDTO);

    Map<Integer,List<FindPostResultDTO>> findTenPosts();

    FindPostResultDTO findPost(String title);

    Post update(String token);

    void delete(String token, DeletePostRequestDTO requestDTO);
}
