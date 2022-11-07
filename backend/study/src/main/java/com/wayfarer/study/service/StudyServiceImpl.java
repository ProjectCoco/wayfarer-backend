package com.wayfarer.study.service;

import com.wayfarer.study.dto.StudyAriticleUpdateRequestDto;
import com.wayfarer.study.dto.StudyArticleRequestDto;
import com.wayfarer.study.dto.StudyDetailResponseDto;
import com.wayfarer.study.dto.StudyResponseDto;
import com.wayfarer.study.entity.StudyArticle;
import com.wayfarer.study.mapper.StudyMapper;
import com.wayfarer.study.mapper.StudyMapperImpl;
import com.wayfarer.study.repository.StudyArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudyServiceImpl implements StudyService{

    private final StudyArticleRepository studyArticleRepository;
    private final StudyMapper studyMapper;


    @Override
    public List<StudyResponseDto> readAllStudyArticles() {
        return null;
    }

    @Override
    public StudyDetailResponseDto readStudyArticle(Long studyId) {
        StudyArticle studyArticle = studyArticleRepository.findById(studyId).orElseThrow(() -> new NullPointerException());

        return null;
    }

    @Override
    public void createStudyArticle(StudyArticleRequestDto studyArticleRequestDto) {
            studyArticleRepository.save(studyMapper.std(studyArticleRequestDto));
    }

    @Override
    public void updateStudyArticle(StudyAriticleUpdateRequestDto studyAriticleUpdateRequestDto) {

    }

    @Override
    public void deleteStudyArticle(Long studyId) {

    }
}
