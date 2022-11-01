package com.wayfarer.study.dto;


import com.wayfarer.study.entity.StudyArticle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class StudyResponseDto {

    private StudyArticle studyArticle;
    private StudyInfo studyInfo;
    private StudyContent studyContent;
    private StudyTime studyTime;

    @Builder
    @Getter @Setter
    public static class StudyArticle{
        private long studyArticleId;

        private String title;

        private String status;
    }

    @Builder
    @Getter @Setter
    public static class StudyInfo{
        private String purpose;

        private LocalDateTime meetTime;

        private String active;
    }

    @Builder
    @Getter @Setter
    public static class StudyContent{
        private String content;

        private String version;
    }

    @Builder
    @Getter @Setter
    public static class StudyTime{
        private LocalDateTime startTime;
        private LocalDateTime deadline;
    }
}
