package com.wayfarer.study.service;

import com.wayfarer.study.dto.*;
import com.wayfarer.study.entity.StudyArticle;
import com.wayfarer.study.mapper.StudyMapper;
import com.wayfarer.study.repository.StudyArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
public class StudyServiceImpl implements StudyService{

    private final StudyArticleRepository studyArticleRepository;
    private final StudyMapper studyMapper;

    @Override
    public MultiResponseDto<StudyArticleResponseDto> readAllStudyArticles(int page) {
        Page<StudyArticle> studyArticleList = studyArticleRepository.findAll(PageRequest.of(page - 1, 10, Sort.by("studyArticleId").descending()));
        return new MultiResponseDto<>(studyMapper.studyArticleListToStudyArticleResponseDtoList(studyArticleList.getContent()), studyArticleList);
    }

    @Override
    public StudyArticleDetailResponseDto readStudyArticle(Long studyId) {
        StudyArticle studyArticle = studyArticleRepository.findById(studyId).orElseThrow(() -> new NullPointerException());
        return studyMapper.studyArticleToStudyDetailResponseDto(studyArticle);
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
        StudyArticle studyArticle = studyArticleRepository.findById(studyId).orElseThrow(NullPointerException::new);
        studyArticle.setStatus("Disable");
        studyArticleRepository.save(studyArticle);
    }
}
