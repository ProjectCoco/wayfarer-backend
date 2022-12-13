package com.wayfarer.study.entity.vo;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Builder
@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class StudyContent {

    @Column( )
    private String content;

    private String version; // null
}
