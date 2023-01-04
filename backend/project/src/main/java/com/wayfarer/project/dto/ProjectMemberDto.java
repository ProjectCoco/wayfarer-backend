package com.wayfarer.project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectMemberDto {

    private Long projectArticleId;

    private String position;

    private int totalMember;

    private int countMember;

    @Builder
    public ProjectMemberDto(Long projectArticleId,
                          String position,
                          int totalMember,
                          int countMember) {
        this.projectArticleId = projectArticleId;
        this.position = position;
        this.totalMember = totalMember;
        this.countMember = countMember;
    }
}
