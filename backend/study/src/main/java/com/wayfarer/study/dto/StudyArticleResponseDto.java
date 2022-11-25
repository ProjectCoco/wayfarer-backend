package com.wayfarer.study.dto;

import com.wayfarer.study.entity.enummodel.StudyStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@Builder
public class StudyArticleResponseDto {
    private Long studyArticleId;

    private String title;

    private String status;

    private LocalDateTime startTime;

    private LocalDateTime deadline;

    private StudyStatus active;

}
