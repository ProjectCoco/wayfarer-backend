package com.wayfarer.study.dto;

import lombok.*;
@Getter @Setter
@Builder
public class StudyArticleResponseDto {
    private long studyArticleId;
    private String title;
    private String contentVersion;
    private String status;

/*    private StudyContentDto studyContent;
    private StudyInfoDto studyInfo;
    private StudyTimeDto studyTime;*/
}
