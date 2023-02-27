package com.wayfarer.community.dto.article;

import lombok.Getter;

import java.util.List;

@Getter
public class CommunityArticleRequestDto {

    private List<Long> topics;

    private String title;

    private String content;
}
