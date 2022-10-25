package com.wayfarer.study.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StudyMember {
    private long studyMemberId;
    String studyRole;
    int memberCount;
    int memberGoalCount;
    long studyArticleId;
}
