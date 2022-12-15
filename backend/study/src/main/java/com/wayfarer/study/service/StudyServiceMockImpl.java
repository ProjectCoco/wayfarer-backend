package com.wayfarer.study.service;

import com.wayfarer.study.dto.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("StudyServiceMock")
@Service
public class StudyServiceMockImpl implements StudyService {


    @Override
    public MultiResponseDto<StudyArticleResponseDto> readAllStudyArticles(int page, Boolean status) {
        return null;
    }

    @Override
    public MultiResponseDto<StudyArticleResponseDto> readStudyArticlesWithTag(int page, String tag, Boolean status) {
        return null;
    }

    @Override
    public MultiResponseDto<StudyArticleResponseDto> readStudyArticlesWithPosition(int page, String positionName, Boolean status) {
        return null;
    }

    @Override
    public StudyArticleDetailResponseDto readStudyArticle(Long studyId) {
        return null;
    }

    @Override
    public void createStudyArticle(StudyArticleRequestDto studyArticleRequestDto) {

    }

    @Override
    public void updateStudyArticle(Long studyId, StudyArticleUpdateRequestDto studyArticleUpdateRequestDto) {

    }

    @Override
    public void deleteStudyArticle(Long studyId) {

    }
}

