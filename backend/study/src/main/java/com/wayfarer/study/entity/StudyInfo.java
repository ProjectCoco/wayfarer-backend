package com.wayfarer.study.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class StudyInfo {
    long studyInfoId;
    String purpose;
    LocalDateTime meetTime;
    String active;
    long studyArticleId;
}
