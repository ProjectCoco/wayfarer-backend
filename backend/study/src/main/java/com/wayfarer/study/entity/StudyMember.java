package com.wayfarer.study.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StudyMember {
    private long studyMemberId;
    private String studyRole;
    private int memberCount;
    private int memberGoalCount;
    private long studyArticleId;
}
