package com.wayfarer.study.service;

import com.wayfarer.study.dto.*;
import com.wayfarer.study.entity.StudyArticle;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudyService {

    /**
     * @return
     */
    List<StudyResponseDto> readAllStudyArticles();

    StudyDetailResponseDto readStudyArticle(Long studyId);

    void createStudyArticle(StudyArticleRequestDto studyArticleRequestDto);

    void updateStudyArticle(StudyAriticleUpdateRequestDto studyAriticleUpdateRequestDto);

    void deleteStudyArticle(Long studyId);
}
