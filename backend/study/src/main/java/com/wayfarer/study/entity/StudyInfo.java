package com.wayfarer.study.entity;

import com.wayfarer.study.entity.enummodel.StudyStatus;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Builder
@Getter
@Setter(value = AccessLevel.PROTECTED)
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class StudyInfo {

    @Column()
    @Enumerated(EnumType.STRING)
    private StudyStatus active; // null

}
