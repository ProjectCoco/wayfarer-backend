package com.wayfarer.study.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudyArticleDetailResponseDto {

    private Long studyArticleId;

    private String title;

    private String status;

    private String content;

    private List<String> studyTags;

    private Long totalMember;

    private Long countMember;

    private LocalDateTime startTime;

    private LocalDateTime deadline;

    private String active;

}
