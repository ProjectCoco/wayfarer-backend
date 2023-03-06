package com.wayfarer.community.dto.article;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommunityArticleUpdateRequestDto {

    private List<Long> topics;

    private String title;

    private String content;

}
