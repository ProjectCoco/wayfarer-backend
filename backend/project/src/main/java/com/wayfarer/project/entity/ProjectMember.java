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

    @Column(nullable = false)
    private Long projectArticleId;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private int totalMember;

    @Column(nullable = false)
    private int countMember;
}
