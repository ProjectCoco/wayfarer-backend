package com.wayfarer.study.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class StudyTime {
    private long studyTimeId;
    private LocalDateTime startTime;
    private LocalDateTime deadline;
    private long studyArticleId;
}
