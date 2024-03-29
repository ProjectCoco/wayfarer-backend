package com.wayfarer.study.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class StudyArticleResponseDto {

    private Long studyArticleId;

    private String title;

    private List<String> studyTags;

    private List<StudyMemberResponseDto> studyMemberResponses;

    private LocalDateTime startTime;

    private LocalDateTime createdTime;

    private String status;

}
