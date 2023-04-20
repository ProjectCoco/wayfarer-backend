package com.wayfarer.community.dto.article;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommunityArticleRequestDto {

    private List<Long> topics;

    private String title;

    private String content;
}
