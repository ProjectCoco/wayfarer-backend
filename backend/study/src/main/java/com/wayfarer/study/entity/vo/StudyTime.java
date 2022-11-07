package com.wayfarer.study.entity.vo;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Builder
@Getter
public class StudyTime {

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime deadline;

}
