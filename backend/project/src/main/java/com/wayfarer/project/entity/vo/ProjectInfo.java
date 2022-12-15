package com.wayfarer.project.entity.vo;

import com.wayfarer.project.entity.enummodel.ProjectStatus;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Builder
@Getter
@Setter(value = AccessLevel.PROTECTED)
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ProjectInfo {

    @Enumerated(EnumType.STRING)
    private ProjectStatus status;
}
