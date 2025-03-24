package com.toyblog.service;

import com.toyblog.dto.CreatePostRequestDTO;
import com.toyblog.dto.DeletePostRequestDTO;
import com.toyblog.dto.FindPostResultDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface PostService {
    void write(CreatePostRequestDTO requestDTO);

    Map<Integer,List<FindPostResultDTO>> findTenPosts();

    FindPostResultDTO findPost(String title);

    void update(String authorId);

    void delete(DeletePostRequestDTO requestDTO);
}
