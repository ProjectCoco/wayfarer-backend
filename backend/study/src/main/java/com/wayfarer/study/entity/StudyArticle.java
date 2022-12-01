package com.wayfarer.study.entity;


import com.wayfarer.study.entity.converter.BooleanToYNConverter;
import com.wayfarer.study.entity.converter.StudyTagConverter;
import com.wayfarer.study.entity.enummodel.StudyStatus;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private Boolean status;

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
    public void updateStudyTags(String studyTags) {
        this.studyTags = studyTags;
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

    public void initStudyArticle() {
        this.status = true;
        this.studyInfo = new StudyInfo(StudyStatus.PROCEED);
    }

    public List<String> getStudyTags(){
        List<String> strings = new ArrayList<>();
        if (this.studyTags != null) {
            strings = Arrays.asList(this.studyTags.split(","));
        }
        return strings;
    }

    public void updateStudyTags(List<String> tags){
        this.studyTags = String.join(",", tags);
    }

}