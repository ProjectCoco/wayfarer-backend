package com.wayfarer.study.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StudySkill {
    private long studySkillId;
    private long skillId;
    private long studyArticleId;
}
