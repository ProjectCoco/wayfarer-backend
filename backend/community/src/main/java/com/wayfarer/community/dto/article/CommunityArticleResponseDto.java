package com.wayfarer.community.dto.article;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommunityArticleResponseDto {

    private String title;

    private String content;

    private Long commentCount;

    private LocalDateTime createdTime;
}
