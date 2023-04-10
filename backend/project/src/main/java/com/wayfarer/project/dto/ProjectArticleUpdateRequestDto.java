package com.wayfarer.project.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectArticleUpdateRequestDto {

    @NotBlank(message = "제목은 하나 이상의 공백이 아닌 문자를 입력해야 합니다.")
    private String title;

    private String projectTags;

    private Long projectTotalMember;

    private String projectSkills;

    private LocalDateTime startTime;

    @NotBlank(message = "본문은 하나 이상의 공백이 아닌 문자를 입력해야 합니다.")
    private String projectContent;

}
