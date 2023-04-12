package com.wayfarer.study.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class StudyMemberUpdateDto {

    private Long studyMemberId;

    private String position;

    @Positive
    private int totalMember;

    @Min(0)
    private int countMember;

}
