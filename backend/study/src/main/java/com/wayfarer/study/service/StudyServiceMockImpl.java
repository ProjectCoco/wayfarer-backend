package com.wayfarer.study.service;

import com.wayfarer.study.dto.MultiResponseDto;
import com.wayfarer.study.dto.StudyArticleUpdateRequestDto;
import com.wayfarer.study.dto.StudyArticleDetailResponseDto;
import com.wayfarer.study.dto.StudyArticleRequestDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("StudyServiceMock")
@Service
public class StudyServiceMockImpl implements StudyService {


    @Override
    public MultiResponseDto readAllStudyArticles(int page) {
        return null;
    }

    @Override
    public MultiResponseDto readStudyArticlesWithTag(int page, String tag) {
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

