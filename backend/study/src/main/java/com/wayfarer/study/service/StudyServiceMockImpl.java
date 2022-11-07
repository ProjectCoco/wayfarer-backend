package com.wayfarer.study.service;

import com.wayfarer.study.dto.MultiResponseDto;
import com.wayfarer.study.dto.StudyAriticleUpdateRequestDto;
import com.wayfarer.study.dto.StudyArticleDetailResponseDto;
import com.wayfarer.study.dto.StudyArticleRequestDto;

public class StudyServiceMockImpl implements StudyService {


    @Override
    public MultiResponseDto readAllStudyArticles(int page) {
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
    public void updateStudyArticle(StudyAriticleUpdateRequestDto studyAriticleUpdateRequestDto) {

    }

    @Override
    public void deleteStudyArticle(Long studyId) {

    }
}

