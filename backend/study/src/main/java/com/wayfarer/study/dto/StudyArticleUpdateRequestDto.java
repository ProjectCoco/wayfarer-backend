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
public class StudyArticleUpdateRequestDto {

    private String target;
    private String title;
    private List<Long> studyMemberList;
    private String content;
    private LocalDateTime deadLine;
    private StudyStatus active;

}