package com.wayfarer.project.entity;

import com.wayfarer.project.entity.vo.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long projectArticleId;

    @Column()
    private String title;

    private Boolean enabled;

    @Column
    private String projectTags;

    @Column
    @CreatedDate
    private LocalDateTime createdTime; // null

    @Embedded
    private ProjectMember projectMember;

    @Embedded
    private ProjectContent projectContent;

    @Embedded
    private ProjectTime projectTime;

    @Embedded
    private ProjectInfo projectInfo;

    @Embedded
    private ProjectOwner projectOwner;

    @Embedded
    private ProjectSkill projectSkill;
}
