package com.wayfarer.study.entity.vo;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Builder
@Getter
@Embeddable
public class StudyInfo {

    @Column(nullable = false)
    private String purpose;

    @Column(nullable = false)
    private String meetTime;

    @Column(nullable = false)
    private String active;

}
