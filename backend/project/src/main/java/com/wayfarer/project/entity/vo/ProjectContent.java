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
public class ProjectContent {

    @Column( )
    private String content;

    private String version; // null
}
