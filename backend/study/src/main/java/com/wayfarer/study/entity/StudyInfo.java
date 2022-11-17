package com.wayfarer.study.entity;

import com.wayfarer.study.entity.enummodel.StudyStatus;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Builder
@Getter
@Setter(value = AccessLevel.PROTECTED)
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class StudyInfo {

    @Column()
    private StudyStatus active;

}
