package com.wayfarer.study.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Setter
@Getter
@NoArgsConstructor
public class StudyMemberRequestDto {

    private String position;

    @Positive
    private int totalMember;

}
