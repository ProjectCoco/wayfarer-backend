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
public class ProjectContent {

    @Column( )
    private String content;

    private String version; // null
}
