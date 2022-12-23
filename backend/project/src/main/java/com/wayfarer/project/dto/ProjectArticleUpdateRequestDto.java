package com.wayfarer.project.dto;


import com.wayfarer.project.entity.vo.ProjectContent;
import com.wayfarer.project.entity.vo.ProjectMember;
import com.wayfarer.project.entity.vo.ProjectSkill;
import com.wayfarer.project.entity.vo.ProjectTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectArticleUpdateRequestDto {
    private String title;
    private String projectTags;
    private Long projectTotalMember;
    private Long projectSkillId;
    private LocalDateTime startTime;
    private String projectContent;

}
