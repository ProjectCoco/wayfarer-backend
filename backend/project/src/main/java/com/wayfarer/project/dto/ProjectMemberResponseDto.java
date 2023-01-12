package com.wayfarer.project.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectMemberResponseDto {
    private Long projectArticleId;

    private String position;

    private int totalMember;

    private int countMember;
}
