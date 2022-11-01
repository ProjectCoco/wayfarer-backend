package com.wayfarer.study.service;

import com.wayfarer.study.dto.StudyResponseDto;
import com.wayfarer.study.helper.StudyStubData;


import java.util.List;

public class StudyServiceMockImpl implements StudyService {

    @Override
    public List<StudyResponseDto> readAllStudyArticles() {
        return StudyStubData.getAllStudyResponseDto();
    }
}

