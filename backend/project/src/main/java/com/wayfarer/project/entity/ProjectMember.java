package com.wayfarer.project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class ProjectMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectMemberId;

    @Column
    private Long projectArticleId;

    @Column
    private String position;

    @Column
    private int totalMember;

    @Column
    private int countMember;
}
