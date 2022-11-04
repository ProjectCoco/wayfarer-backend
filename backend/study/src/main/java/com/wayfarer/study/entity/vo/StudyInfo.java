package com.wayfarer.study.entity.vo;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Builder
@Getter
@Embeddable
public class StudyInfo {

    private String purpose;
    private String meetTime;
    private String active;

}
