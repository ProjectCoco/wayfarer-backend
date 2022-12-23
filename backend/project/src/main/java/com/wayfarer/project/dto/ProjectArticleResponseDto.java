package com.wayfarer.project.dto;


import com.wayfarer.project.entity.enummodel.ProjectStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ProjectArticleResponseDto {
    private Long projectArticleId;

    private String title;

    private String enabled;

    private String positionName;

    private List<String> projectTags;

    private Long totalMember;

    private Long countMember;

    private LocalDateTime startTime;

    private ProjectStatus status;
}