package com.wayfarer.study.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudyMemberResponseDto {

    private Long studyMemberId;

    private String position;

    private int totalMember;

    private int countMember;

}
