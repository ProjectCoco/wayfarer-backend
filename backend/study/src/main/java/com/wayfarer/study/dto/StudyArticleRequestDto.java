package com.wayfarer.study.dto;

import com.wayfarer.study.entity.enummodel.StudyStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudyArticleRequestDto {

    private String title;
    private Long totalMember;
    private String content;
    private String studyTags;
    private LocalDateTime startTime;
    private LocalDateTime deadline;

}
//          {
//        "title":"titleeeeeeeeeeeee",
//        "studyMemberList": [
//        1,2,3
//        ],
//        "content":"contentssssssssssssss",
//        "startTime":"2007-12-03T10:15:30",
//        "deadline":"2007-12-03T10:15:30"
//        }