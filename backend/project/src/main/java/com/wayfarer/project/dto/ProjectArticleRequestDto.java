package com.wayfarer.project.dto;


import com.wayfarer.project.entity.enummodel.ProjectSkillEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectArticleRequestDto {

    @NotBlank(message = "제목은 하나 이상의 공백이 아닌 문자를 입력해야 합니다.")
    private String title;

    @NotBlank(message = "본문은 하나 이상의 공백이 아닌 문자를 입력해야 합니다.")
    private String content;

    private List<String> projectTags;

    private LocalDateTime startTime;

    private List<ProjectSkillEnum> projectSkills;

    private List<ProjectMemberRequestDto> projectMember;

}