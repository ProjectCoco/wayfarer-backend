package com.wayfarer.study.service;

import com.wayfarer.study.dto.StudyArticleResponseDto;
import com.wayfarer.study.dto.StudyResponseDto;
import com.wayfarer.study.entity.StudyArticle;
import com.wayfarer.study.helper.StudyStubData;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public class StudyServiceMockImpl implements StudyService {

    @Override
    public List<StudyResponseDto> readAllStudyArticles() {
        return StudyStubData.getAllStudyResponseDto();
    }
}

