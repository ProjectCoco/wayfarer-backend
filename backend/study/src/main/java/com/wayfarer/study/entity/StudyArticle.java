package com.wayfarer.study.entity;


import com.wayfarer.common.audit.Auditable;
import com.wayfarer.study.entity.converter.BooleanToYNConverter;
import com.wayfarer.study.entity.enummodel.StudyStatus;
import com.wayfarer.study.entity.vo.StudyContent;
import com.wayfarer.study.entity.vo.StudyInfo;
import com.wayfarer.study.entity.vo.StudyTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudyArticle extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studyArticleId;

    @Column(nullable = false, length = 30)
    private String title;

    @Convert(converter = BooleanToYNConverter.class)
    @Column(nullable = false)
    private Boolean enabled;

//    @Convert(converter = StudyTagConverter.class)
    @Column(nullable = false)
    private String studyTags;

    @Column(nullable = false)
    private String studyMembers;

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

    public void changeStatus(StudyStatus status) {
        this.studyInfo.setStatus(status);
    }

    public void changeEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void initStudyArticle() {
        this.enabled = true;
        this.studyInfo = new StudyInfo(StudyStatus.PROCEED);
    }

    public List<String> getStudyTags(){
        List<String> strings = new ArrayList<>();
        if (this.studyTags != null) {
            strings = Arrays.asList(this.studyTags.split(","));
        }
        return strings;
    }

    public void setStudyTags(List<String> tags){
        this.studyTags = String.join(",", tags);
    }

    public List<String> getStudyMembers(){
        List<String> strings = new ArrayList<>();
        if (this.studyMembers != null) {
            strings = Arrays.asList(this.studyMembers.split(","));
        }
        return strings;
    }

    public void setStudyMembers(List<String> studyMembers){
        this.studyMembers = String.join(",", studyMembers);
    }

}