package com.wayfarer.community.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class CommunityArticleRequestDto {

    private List<Long> topics;

    private String title;

    private String content;
}
