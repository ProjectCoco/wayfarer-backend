package com.wayfarer.project.dto;

import com.wayfarer.project.entity.enummodel.ProjectSkillEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ProjectArticlePutRequestDto {
    private String title;
    private List<String> projectTags;
    private List<ProjectSkillEnum> projectSkills;
    private LocalDateTime startTime;
    private String projectContent;
    private List<ProjectMemberUpdateDto> projectMembers;
}
