package com.wayfarer.project.entity.vo;


import lombok.*;

import javax.persistence.Embeddable;

@Builder
@Getter
@Setter(value = AccessLevel.PROTECTED)
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ProjectSkill {
    private String skillId;

}
