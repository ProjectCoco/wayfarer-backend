package com.wayfarer.study.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class StudyMemberRequestDto {
    private String position;
    private int totalMember;
}
