package com.wayfarer.study.entity;


import com.wayfarer.study.entity.converter.BooleanToYNConverter;
import com.wayfarer.study.entity.converter.StudyMemberListConverter;
import com.wayfarer.study.entity.enummodel.StudyStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudyArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studyArticleId;

    @Column()
    private String title;

    @Convert(converter = BooleanToYNConverter.class)
    private Boolean status;

    @Convert(converter = StudyMemberListConverter.class)
    @Column
    private List<Long> studyMemberList;

    @Embedded
    private StudyContent studyContent;

    @Embedded
    private StudyTime studyTime;

    @Embedded
    private StudyInfo studyInfo;

    @Embedded
    private StudyOwner studyOwner;

    
    public void changeTitle(String title) {
        this.title = title;
    }

    public void updateStudyContent(String content) {
        this.studyContent.setContent(content);
    }

    public void changeStudyMemberList(List<Long> studyMemberList) {
        this.studyMemberList = studyMemberList;
    }

    public void changeDeadLine(LocalDateTime deadLine) {
        this.studyTime.setDeadline(deadLine);
    }

    public void changeActive(StudyStatus active) {
        this.studyInfo.setActive(active);
    }

    public void changeStatus(boolean status) {
        this.status = status;
    }
}