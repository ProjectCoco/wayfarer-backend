package com.wayfarer.project.dto;


import com.wayfarer.project.entity.enummodel.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectArticleResponseDto {
    private Long projectArticleId;

    private String title;

    private List<String> projectTags;

    private List<String> projectSkills;

    private List<ProjectMemberResponseDto> projectMemberResponses;

    private LocalDateTime startTime;

    private LocalDateTime createdTime;

    private ProjectStatus status;
}