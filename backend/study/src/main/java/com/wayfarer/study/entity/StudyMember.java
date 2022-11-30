package com.wayfarer.study.entity;

import lombok.*;

import javax.persistence.*;



@Builder
@Getter
@Setter(value = AccessLevel.PROTECTED)
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class StudyMember {

    @Column()
    private Long totalMember;

    @Column()
    private Long countMember;
}
