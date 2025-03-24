package com.toyblog.service.impl;

import com.toyblog.dto.AuthorDTO;
import com.toyblog.dto.CreatePostRequestDTO;
import com.toyblog.dto.DeletePostRequestDTO;
import com.toyblog.dto.FindPostResultDTO;
import com.toyblog.entity.Post;
import com.toyblog.exception.InvalidTokenException;
import com.toyblog.repository.PostRepository;
import com.toyblog.repository.UserRepository;
import com.toyblog.service.PostService;
import com.toyblog.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final JwtUtil jwtUtil;

    @Override
    public Post write(String token, CreatePostRequestDTO requestDTO) {
        validToken(token);
        String authorId = jwtUtil.extractUserId(token);
        Post post = new Post(requestDTO.title(), requestDTO.content(), authorId, requestDTO.tags());

        postRepository.save(post);
        return post;
    }

    @Override
    public Map<Integer, List<FindPostResultDTO>> findTenPosts() {
        List<Post> list = postRepository.findAll();
        List<FindPostResultDTO> saveList = new ArrayList<>();
        Map<Integer, List<FindPostResultDTO>> postMap = new HashMap<>();
        int j = 1;
        for (int i = 0; i < list.size(); i++) {
            Post post = list.get(i);
            AuthorDTO author = AuthorDTO.create(userRepository.findById(post.getAuthorId()));
            saveList.add(FindPostResultDTO.findTenPosts(post, author));
            if ((i+1) % 10 == 0) {
                postMap.put(j++, saveList);
                saveList = new ArrayList<>();
            }
        }
        postMap.put(j, saveList);
        return postMap;
    }

    @Override
    public FindPostResultDTO findPost(String title) {
        Post post = postRepository.findByTitle(title);
        AuthorDTO author = AuthorDTO.create(userRepository.findById(post.getAuthorId()));
        return FindPostResultDTO.findPost(post, author);
    }

    @Override
    public Post update(String token) {
        validToken(token);
        return null;
    }

    @Override
    public void delete(String token, DeletePostRequestDTO requestDTO) {
        validToken(token);
    }

    private void validToken(String token) {
        Boolean validated = jwtUtil.validateToken(token);
        if (!validated) {
            throw new InvalidTokenException("유효하지 않은 토큰입니다.");
        }
    }
}
