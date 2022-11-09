package com.wayfarer.study.service;

import com.wayfarer.study.dto.*;
import com.wayfarer.study.entity.StudyArticle;
import com.wayfarer.study.entity.vo.StudyContent;
import com.wayfarer.study.mapper.StudyMapper;
import com.wayfarer.study.repository.StudyArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Primary
@Service
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
    public void updateStudyArticle(Long studyId, StudyArticleUpdateRequestDto studyArticleUpdateRequestDto) {
        StudyArticle studyArticle = studyArticleRepository.findById(studyId).orElseThrow();

        if (studyArticleUpdateRequestDto.getTarget().equals("content")) {
            //todo refactor

            //studyArticle.updateStudyCountet(content);
            StudyContent studyContent = new StudyContent();
            studyContent.setContent(studyArticleUpdateRequestDto.getContent());
            studyArticle.setStudyContent(studyContent);
            return;
        }
        if (studyArticleUpdateRequestDto.getTarget().equals("title")) {
            studyArticle.setTitle(studyArticleUpdateRequestDto.getTitle());
            return;
        }
        if (studyArticleUpdateRequestDto.getTarget().equals("studyMemberList")) {
            //todo make method
            return;
        }
    }

    @Override
    public void deleteStudyArticle(Long studyId) {
        StudyArticle studyArticle = studyArticleRepository.findById(studyId).orElseThrow(NullPointerException::new);
        studyArticle.setStatus("Disable");
        studyArticleRepository.save(studyArticle);
    }
}
