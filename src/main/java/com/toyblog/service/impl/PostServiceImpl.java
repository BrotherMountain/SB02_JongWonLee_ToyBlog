package com.toyblog.service.impl;

import com.toyblog.dto.*;
import com.toyblog.entity.Image;
import com.toyblog.entity.Post;
import com.toyblog.entity.PostImage;
import com.toyblog.exception.InvalidTokenException;
import com.toyblog.repository.ImageRepository;
import com.toyblog.repository.PostImageRepository;
import com.toyblog.repository.PostRepository;
import com.toyblog.repository.UserRepository;
import com.toyblog.service.PostService;
import com.toyblog.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final ImageRepository imageRepository;
    private final PostImageRepository postImageRepository;
    private final JwtUtil jwtUtil;

    @Override
    public Post write(String token, CreatePostRequestDTO requestDTO, List<Optional<CreateImageRequestDTO>> optionalImageList) {
        validToken(token);
        String authorId = jwtUtil.extractUserId(token);
        Post post = new Post(requestDTO.title(), requestDTO.content(), authorId, requestDTO.tags());

        postRepository.save(post);
        //1번 이미지 저장
        List<UUID> idList = makeImage(optionalImageList);

        //2번 postImage 저장
        for (UUID imageId : idList) {
            PostImage postImage = new PostImage(post.getId(), imageId);
            postImageRepository.save(postImage);
        }

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
            if ((i + 1) % 10 == 0) {
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
        postRepository.delete(requestDTO.id());
        //image Repository 삭제, Post Image Repository 삭제
        UUID targetId = postImageRepository.getPostImageIdByPostId(requestDTO.id());
        if (targetId != null) {
            postImageRepository.delete(targetId);
        }
    }

    private void validToken(String token) {
        Boolean validated = jwtUtil.validateToken(token);
        if (!validated) {
            throw new InvalidTokenException("유효하지 않은 토큰입니다.");
        }
    }

    private List<UUID> makeImage(List<Optional<CreateImageRequestDTO>> optionalImageList) {
        return optionalImageList.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(this::saveImage)
                .collect(Collectors.toList());
    }

    private UUID saveImage(CreateImageRequestDTO imageRequestDTO) {
        Image image = new Image(imageRequestDTO.originalName(), imageRequestDTO.extension(), (long) imageRequestDTO.bytes().length, imageRequestDTO.bytes());
        imageRepository.save(image);
        return image.getId();
    }
}
