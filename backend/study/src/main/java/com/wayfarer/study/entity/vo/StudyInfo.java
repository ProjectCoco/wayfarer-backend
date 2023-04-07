package com.wayfarer.study.entity.vo;

import com.wayfarer.study.entity.enummodel.StudyStatus;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Builder
@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class StudyInfo {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StudyStatus status; // null

}
