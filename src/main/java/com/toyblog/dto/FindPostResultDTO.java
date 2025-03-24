package com.toyblog.dto;

import com.toyblog.entity.Post;
import lombok.Builder;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Builder
public record FindPostResultDTO(
    UUID id,
    String title,
    String content,
    String authorId,
    String authorNickname,
    Instant createdAt,
    List<String> tags
) {
    public static FindPostResultDTO findTenPosts(Post post, AuthorDTO author) {
        return FindPostResultDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent().substring(0, Math.min(post.content.length(), 50)))
                .authorId(author.id())
                .authorNickname(author.nickname())
                .tags(post.getTags())
                .build();
    }

    public static FindPostResultDTO findPost(Post post, AuthorDTO author) {
        return FindPostResultDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .authorId(author.id())
                .authorNickname(author.nickname())
                .tags(post.getTags())
                .build();
    }
}
