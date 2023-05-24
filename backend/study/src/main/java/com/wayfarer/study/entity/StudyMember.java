package com.wayfarer.study.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class StudyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studyMemberId;

    @Column(nullable = false)
    private Long studyArticleId;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private int totalMember;

    @Column(nullable = false)
    private int countMember;

}
