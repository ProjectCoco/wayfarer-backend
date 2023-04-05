package com.wayfarer.project.entity.vo;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Builder
@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ProjectSkill {

    @Column(nullable = false)
    private Long skillId;

}
