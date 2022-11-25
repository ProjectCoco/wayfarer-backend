package com.wayfarer.study.service;

import com.wayfarer.study.dto.*;
import com.wayfarer.study.entity.StudyArticle;
import com.wayfarer.study.entity.enummodel.StudyArticleEnum;
import com.wayfarer.study.mapper.StudyMapper;
import com.wayfarer.study.repository.StudyArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Primary
@Service
@RequiredArgsConstructor
@Transactional
public class StudyServiceImpl implements StudyService{

    private final StudyArticleRepository studyArticleRepository;
    private final StudyMapper studyMapper;

    @Override
    public MultiResponseDto<StudyArticleResponseDto> readAllStudyArticles(int page) {
        Page<StudyArticle> studyArticleList = studyArticleRepository.findAll(PageRequest.of(page - 1, 10, Sort.by(StudyArticleEnum.STUDY_ARTICLE_ID.getValue()).descending()));
        return new MultiResponseDto<>(studyMapper.studyArticleListToStudyArticleResponseDtoList(studyArticleList.getContent()), studyArticleList);
    }

    @Override
    public StudyArticleDetailResponseDto readStudyArticle(Long studyId) {
        StudyArticle studyArticle = studyArticleRepository.findById(studyId).orElseThrow(() -> new NullPointerException());
        return studyMapper.studyArticleToStudyDetailResponseDto(studyArticle);
    }

    @Override
    public void createStudyArticle(StudyArticleRequestDto studyArticleRequestDto) {
        //todo: 코드 단축시키기 init을 mapper default로
        StudyArticle studyArticle = studyMapper.studyRequestDtoToStudyArticle(studyArticleRequestDto);
        studyArticle.initStudyArticle();
        studyArticleRepository.save(studyArticle);
    }

    @Override
    public void updateStudyArticle(Long studyId, StudyArticleUpdateRequestDto studyArticleUpdateRequestDto) {
        StudyArticle studyArticle = studyArticleRepository.findById(studyId).orElseThrow();
        String target = studyArticleUpdateRequestDto.getTarget();

        if (target.equals(StudyArticleEnum.CONTENT.getValue())) {
            updateContent(studyArticleUpdateRequestDto, studyArticle);
            return;
        }
        if (target.equals(StudyArticleEnum.TITLE.getValue())) {
            updateTitle(studyArticleUpdateRequestDto, studyArticle);
            return;
        }
        if (target.equals(StudyArticleEnum.STUDY_MEMBER_LIST.getValue())) {
            updateMemberList(studyArticleUpdateRequestDto, studyArticle);
            return;
        }
        if (target.equals(StudyArticleEnum.DEAD_LINE.getValue())) {
            updateDeadline(studyArticleUpdateRequestDto, studyArticle);
            return;
        }
        if (target.equals(StudyArticleEnum.ACTIVE.getValue())) {
            updateActive(studyArticleUpdateRequestDto, studyArticle);
            return;
        }
    }

    @Override
    public void deleteStudyArticle(Long studyId) {
        StudyArticle studyArticle = studyArticleRepository.findById(studyId).orElseThrow(NullPointerException::new);
        studyArticle.changeStatus(false);
        studyArticleRepository.save(studyArticle);
    }

    private void updateActive(StudyArticleUpdateRequestDto studyArticleUpdateRequestDto, StudyArticle studyArticle) {
        studyArticle.changeActive(studyArticleUpdateRequestDto.getActive());
        studyArticleRepository.save(studyArticle);
    }

    private void updateDeadline(StudyArticleUpdateRequestDto studyArticleUpdateRequestDto, StudyArticle studyArticle) {
        studyArticle.changeDeadLine(studyArticleUpdateRequestDto.getDeadLine());
        studyArticleRepository.save(studyArticle);
    }

    private void updateMemberList(StudyArticleUpdateRequestDto studyArticleUpdateRequestDto, StudyArticle studyArticle) {
        studyArticle.changeStudyMemberList(studyArticleUpdateRequestDto.getStudyMemberList());
        studyArticleRepository.save(studyArticle);
    }

    private void updateTitle(StudyArticleUpdateRequestDto studyArticleUpdateRequestDto, StudyArticle studyArticle) {
        studyArticle.changeTitle(studyArticleUpdateRequestDto.getTitle());
        studyArticleRepository.save(studyArticle);
    }

    private void updateContent(StudyArticleUpdateRequestDto studyArticleUpdateRequestDto, StudyArticle studyArticle) {
        studyArticle.updateStudyContent(studyArticleUpdateRequestDto.getContent());
        studyArticleRepository.save(studyArticle);
        return;
    }
}
