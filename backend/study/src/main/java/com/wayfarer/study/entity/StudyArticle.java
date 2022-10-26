package com.wayfarer.study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudyArticle {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long studyArticleId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contentVersion;

    @Column(nullable = false)
    private String status;
}
