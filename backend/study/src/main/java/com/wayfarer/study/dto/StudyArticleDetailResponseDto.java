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

    private String enabled;

    private String content;

    private List<String> studyTags;

    private List<StudyMemberResponseDto> studyMemberResponses;

    private LocalDateTime startTime;

    private LocalDateTime createdTime;

    private String status;

}
