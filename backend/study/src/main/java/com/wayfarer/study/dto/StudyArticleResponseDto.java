package com.wayfarer.study.dto;

import com.wayfarer.study.entity.enummodel.StudyStatus;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@Builder
public class StudyArticleResponseDto {
    private Long studyArticleId;

    private String title;

    private String enabled;

    private String positionName;

    private List<String> studyTags;

    private Long totalMember;

    private Long countMember;

    private LocalDateTime startTime;

    private LocalDateTime deadline;

    private StudyStatus status;

}
