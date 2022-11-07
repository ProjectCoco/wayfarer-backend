package com.wayfarer.study.entity;

import com.wayfarer.study.entity.vo.StudyContent;
import com.wayfarer.study.entity.vo.StudyInfo;
import com.wayfarer.study.entity.vo.StudyOwner;
import com.wayfarer.study.entity.vo.StudyTime;
import jdk.jfr.StackTrace;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudyArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studyArticleId;

    @Column()
    private String title;

    @Column()
    private String status;

    @Embedded
    private StudyContent studyContent;

    @Embedded
    private StudyTime studyTime;

    @Embedded
    private StudyInfo studyInfo;

    @Embedded
    private StudyOwner studyOwner;

}