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

    @Column
    private Long studyArticleId;

    @Column
    private String position;

    @Column
    private int totalMember;

    @Column
    private int countMember;

}
