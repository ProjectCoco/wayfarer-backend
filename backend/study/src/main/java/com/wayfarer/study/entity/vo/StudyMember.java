package com.wayfarer.study.entity.vo;

import lombok.*;

import javax.persistence.*;



@Builder
@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class StudyMember {

    @Column()
    private Long totalMember;

    @Column()
    private Long countMember;
}
