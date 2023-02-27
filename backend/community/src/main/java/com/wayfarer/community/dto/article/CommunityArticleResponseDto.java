package com.wayfarer.community.dto.article;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommunityArticleResponseDto {

    private String title;

    private String content;

    private Long commentCount;

    private LocalDateTime createdTime;
}
