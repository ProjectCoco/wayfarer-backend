package com.wayfarer.study.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StudyContent {
        private long studyContentId;
        private String content;
        private String version;
        private long studyArticleId;
}
