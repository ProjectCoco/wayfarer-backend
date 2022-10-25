package com.wayfarer.study.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StudyArticle {

    private long studyArticleId;
    private String title;
    private String contentVersion;
    private String status;

}
