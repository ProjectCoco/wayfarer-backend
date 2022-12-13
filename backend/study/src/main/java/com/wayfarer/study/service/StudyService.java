package com.wayfarer.study.service;

import com.wayfarer.study.dto.*;

public interface StudyService {

    /**
     * @return
     */
    MultiResponseDto readAllStudyArticles(int page);

    MultiResponseDto readStudyArticlesWithTag(int page, String tag);

    // todo: readAll 메서드와 함께 동적쿼리로 가능?
    MultiResponseDto readStudyArticlesWithPosition(int page, String positionName);

    StudyArticleDetailResponseDto readStudyArticle(Long studyId);

    void createStudyArticle(StudyArticleRequestDto studyArticleRequestDto);

    void updateStudyArticle(Long studyId, StudyArticleUpdateRequestDto studyArticleUpdateRequestDto);

    void deleteStudyArticle(Long studyId);


}
