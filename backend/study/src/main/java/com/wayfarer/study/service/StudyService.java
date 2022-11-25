package com.wayfarer.study.service;

import com.wayfarer.study.dto.*;

public interface StudyService {

    /**
     * @return
     */
    MultiResponseDto readAllStudyArticles(int page);

    StudyArticleDetailResponseDto readStudyArticle(Long studyId);

    void createStudyArticle(StudyArticleRequestDto studyArticleRequestDto);

    void updateStudyArticle(Long studyId, StudyArticleUpdateRequestDto studyArticleUpdateRequestDto);

    void deleteStudyArticle(Long studyId);
}
