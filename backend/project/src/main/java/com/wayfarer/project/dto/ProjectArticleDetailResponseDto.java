package com.wayfarer.project.dto;



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
public class ProjectArticleDetailResponseDto {

    private Long projectArticleId;

    private String title;

    private String enabled;

    private String content;

    private List<String> projectTags;

    private Long totalMember;

    private Long countMember;

    private LocalDateTime startTime;

    private String status;
}
