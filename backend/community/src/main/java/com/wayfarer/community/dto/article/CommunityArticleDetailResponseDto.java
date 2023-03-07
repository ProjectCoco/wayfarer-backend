package com.wayfarer.community.dto.article;

import com.wayfarer.community.dto.comment.CommunityCommentResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CommunityArticleDetailResponseDto {

    private String title;

    private String content;

    private LocalDateTime createdTime;

    private List<CommunityCommentResponseDto> comments;
}
