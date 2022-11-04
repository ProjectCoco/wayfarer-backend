package com.wayfarer.study.entity.vo;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class StudyTime {

    private LocalDateTime startTime;
    private LocalDateTime deadline;

}
