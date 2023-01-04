package com.wayfarer.study.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudyMemberUpdateDto {
    private Long studyMemberId;

    private String position;

    private int totalMember;

    private int countMember;
}
