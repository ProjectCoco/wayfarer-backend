package com.wayfarer.project.dto;

import com.wayfarer.project.entity.enummodel.ProjectSkillEnum;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ProjectArticlePutRequestDto {

    @NotBlank(message = "제목은 하나 이상의 공백이 아닌 문자를 입력해야 합니다.")
    private String title;

    private List<String> projectTags;

    private List<ProjectSkillEnum> projectSkills;

    private LocalDateTime startTime;

    @NotBlank(message = "본문은 하나 이상의 공백이 아닌 문자를 입력해야 합니다.")
    private String projectContent;

    private List<ProjectMemberUpdateDto> projectMembers;
}
