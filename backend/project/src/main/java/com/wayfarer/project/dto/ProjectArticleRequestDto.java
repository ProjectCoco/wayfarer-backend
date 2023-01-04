package com.wayfarer.project.dto;


import com.wayfarer.project.entity.enummodel.ProjectSkillEnum;
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
public class ProjectArticleRequestDto {
    private String title;
    private String content;
    private List<String> projectTags;
    private LocalDateTime startTime;
    private List<ProjectSkillEnum> projectSkills;
    private List<ProjectMemberRequestDto> projectMember;
}