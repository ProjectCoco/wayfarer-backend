package com.wayfarer.study.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StudyOwner {
    private long studyOwnerId;
    private long ownerId;
    private long studyArticleId;
}
