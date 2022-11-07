package com.wayfarer.study.service;

import com.wayfarer.study.dto.*;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudyService {

    /**
     * @return
     */
    MultiResponseDto readAllStudyArticles(int page);

    StudyArticleDetailResponseDto readStudyArticle(Long studyId);

    void createStudyArticle(StudyArticleRequestDto studyArticleRequestDto);

    void updateStudyArticle(StudyAriticleUpdateRequestDto studyAriticleUpdateRequestDto);

    void deleteStudyArticle(Long studyId);
}
