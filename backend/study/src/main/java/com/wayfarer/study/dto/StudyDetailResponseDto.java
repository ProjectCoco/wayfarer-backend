package com.wayfarer.study.dto;

import com.wayfarer.study.entity.vo.StudyContent;
import com.wayfarer.study.entity.vo.StudyInfo;
import com.wayfarer.study.entity.vo.StudyOwner;
import com.wayfarer.study.entity.vo.StudyTime;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudyDetailResponseDto {

    private Long studyArticleId;

    private String title;

    private String status;

    private String content;

    private LocalDateTime startTime;

    private LocalDateTime deadline;

    private String purpose;

    private String meetTime;

    private String active;

}
