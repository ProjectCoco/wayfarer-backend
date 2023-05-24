package com.wayfarer.study.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class StudyArticlePutRequestDto {

    @NotBlank(message = "제목은 하나 이상의 공백이 아닌 문자를 입력해야 합니다.")
    private String title;

    private List<String> studyTags;

    private LocalDateTime startTime;

    @NotBlank(message = "본문은 하나 이상의 공백이 아닌 문자를 입력해야 합니다.")
    private String studyContent;

    private List<StudyMemberUpdateDto> studyMember;
}
