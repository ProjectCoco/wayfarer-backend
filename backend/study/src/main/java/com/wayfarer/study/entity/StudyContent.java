package com.wayfarer.study.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Builder
@Getter
@Setter(value = AccessLevel.PROTECTED)
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class StudyContent {

    @Column( )
    private String content;

    private String version; // null
}
