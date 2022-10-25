package com.wayfarer.study.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StudyTag {
    private long studyTagId;
    private long tagId;
    private long studyArticleId;
}
