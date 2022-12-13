package com.wayfarer.study.entity.vo;

import lombok.*;

import javax.persistence.Embeddable;

@Builder
@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class StudyPosition {
    private String positionName;
}