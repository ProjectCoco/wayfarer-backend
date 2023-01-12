package com.wayfarer.project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectMemberUpdateDto {

    private Long projectMemberId;

    private String position;

    private int totalMember;

    private int countMember;
}
