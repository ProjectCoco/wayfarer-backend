package com.wayfarer.study.service;

import com.wayfarer.common.dto.MultiResponseDto;
import com.wayfarer.study.dto.*;
import com.wayfarer.study.entity.enummodel.StudyStatus;

public interface StudyService {

    MultiResponseDto<StudyArticleResponseDto> readAllStudyArticles(int page, Boolean status);

    MultiResponseDto<StudyArticleResponseDto> readStudyArticlesWithTag(int page, String tag, Boolean status);

    MultiResponseDto<StudyArticleResponseDto> readStudyArticlesWithPosition(int page, String positionName, StudyStatus status);

    StudyArticleDetailResponseDto readStudyArticle(Long studyId);

    void createStudyArticle(StudyArticleRequestDto studyArticleRequestDto);

    void putStudyArticle(Long studyId, StudyArticlePutRequestDto studyArticlePutRequestDto);

    void updateStudyArticle(Long studyId, StudyArticleUpdateRequestDto studyArticleUpdateRequestDto);

    void deleteStudyArticle(Long studyId);


}
