package com.wayfarer.study.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudyArticleDetailResponseDto {

    private Long studyArticleId;

    private String title;

    private String status;

    private String content;

    private LocalDateTime startTime;

    private LocalDateTime deadline;

    private String purpose;

    private String meetTime;

    private String active;

}
