package com.wayfarer.project.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter
@Setter
public class ProjectMemberRequestDto {

    private String position;

    @Positive
    private int totalMember;
}
