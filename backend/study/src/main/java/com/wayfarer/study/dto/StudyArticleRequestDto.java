package com.wayfarer.study.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudyArticleRequestDto {

    private String title;
    private String content;
    private List<String> studyTags;
    private LocalDateTime startTime;
    private List<StudyMemberRequestDto> studyMember;

}
