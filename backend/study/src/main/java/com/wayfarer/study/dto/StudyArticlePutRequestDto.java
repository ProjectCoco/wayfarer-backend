package com.wayfarer.study.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class StudyArticlePutRequestDto {
    private String title;
    private List<String> studyTags;
    private LocalDateTime startTime;
    private String studyContent;
    private List<StudyMemberUpdateDto> studyMember;
}
