package com.wayfarer.study.dto;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class StudyMemberDto {

    private Long studyArticleId;

    private String position;

    private int totalMember;

    private int countMember;

    @Builder
    public StudyMemberDto(Long studyArticleId,
                               String position,
                               int totalMember,
                               int countMember) {
        this.studyArticleId = studyArticleId;
        this.position = position;
        this.totalMember = totalMember;
        this.countMember = countMember;
    }
}
