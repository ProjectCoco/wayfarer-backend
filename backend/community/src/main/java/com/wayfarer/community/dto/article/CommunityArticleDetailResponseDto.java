package com.wayfarer.community.dto.article;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class CommunityArticleDetailResponseDto {

    private String title;

    private String content;

    private LocalDateTime createdTime;

    private List<Long> topics;

//    private List<CommentResponseDto> comments;
}
