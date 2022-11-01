package com.wayfarer.study.dto;

import com.wayfarer.study.entity.StudyContent;
import com.wayfarer.study.entity.StudyInfo;
import com.wayfarer.study.entity.StudyTime;
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
