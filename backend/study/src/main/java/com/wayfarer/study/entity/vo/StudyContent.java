package com.wayfarer.study.entity.vo;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Builder
@Getter
@Embeddable
public class StudyContent {

        @Column(nullable = false)
     private String content;
     private String version;
}
