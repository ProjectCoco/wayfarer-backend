package com.wayfarer.project.entity.vo;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Builder
@Getter
@Setter(value = AccessLevel.PROTECTED)
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMember {

    //todo: 역할(role)과 관련되어 있음

    @Column()
    private Long totalMember;

    @Column()
    private Long countMember;
}
