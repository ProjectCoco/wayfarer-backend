package com.wayfarer.project.dto;


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
    private String projectSkills;
    private LocalDateTime startTime;
    private String projectContent;

}
