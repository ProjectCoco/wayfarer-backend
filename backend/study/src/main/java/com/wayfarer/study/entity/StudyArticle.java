package com.wayfarer.study.entity;


import com.wayfarer.study.entity.converter.BooleanToYNConverter;
import com.wayfarer.study.entity.enummodel.StudyStatus;
import com.wayfarer.study.entity.vo.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Convert(converter = BooleanToYNConverter.class)
    private Boolean enabled;

//    @Convert(converter = StudyTagConverter.class)
    @Column
    private String studyTags;

    @Column
    @CreatedDate
    private LocalDateTime createdTime; // null

    @Embedded
    private StudyMember studyMember;

    @Embedded
    private StudyContent studyContent;

    @Embedded
    private StudyTime studyTime;

    @Embedded
    private StudyInfo studyInfo;

    @Embedded
    private StudyOwner studyOwner;

    @Embedded
    private StudyPosition studyPosition;


    public void changeTitle(String title) {
        this.title = title;
    }

    public void updateStudyContent(String content) {
        this.studyContent.setContent(content);
    }

    public void updateStudyTotalMember(Long studyTotalMember) {
        this.studyMember.setTotalMember(studyTotalMember);
    }
    public void updateStudyCountMember(Long studyCountMember) {
        this.studyMember.setCountMember(studyCountMember);
    }

    public void changeDeadLine(LocalDateTime deadLine) {
        this.studyTime.setDeadline(deadLine);
    }

    public void changeActive(StudyStatus active) {
        this.studyInfo.setActive(active);
    }

    public void changeStatus(boolean enabled) {
        this.enabled = enabled;
    }

    public void initStudyArticle() {
        this.enabled = true;
        this.studyInfo = new StudyInfo(StudyStatus.PROCEED);
        this.studyMember.setCountMember(0L);
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

}