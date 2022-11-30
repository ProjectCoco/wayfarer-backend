package com.wayfarer.study.service;

import com.wayfarer.study.dto.*;

public interface StudyService {

    /**
     * @return
     */
    MultiResponseDto readAllStudyArticles(int page);

    MultiResponseDto readStudyArticlesWithTag(int page, String tag);

    StudyArticleDetailResponseDto readStudyArticle(Long studyId);

    void createStudyArticle(StudyArticleRequestDto studyArticleRequestDto);

    void updateStudyArticle(Long studyId, StudyArticleUpdateRequestDto studyArticleUpdateRequestDto);

    void deleteStudyArticle(Long studyId);


}
