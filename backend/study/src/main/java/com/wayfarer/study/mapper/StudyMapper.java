package com.wayfarer.study.mapper;

import com.wayfarer.study.dto.StudyArticleDetailResponseDto;
import com.wayfarer.study.dto.StudyArticleRequestDto;
import com.wayfarer.study.dto.StudyArticleResponseDto;
import com.wayfarer.study.entity.StudyArticle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudyMapper {

    @Mapping(source = "studyContent.content", target = "content")
    @Mapping(source = "studyInfo.purpose", target = "purpose")
    @Mapping(source = "studyInfo.meetTime", target = "meetTime")
    @Mapping(source = "studyInfo.active", target = "active")
    @Mapping(source = "studyTime.startTime", target = "startTime")
    @Mapping(source = "studyTime.deadline", target = "deadline")
    StudyArticleDetailResponseDto studyArticleToStudyDetailResponseDto(StudyArticle studyArticle);

    @Mapping(source = "studyInfo.active", target = "active")
    @Mapping(source = "studyTime.startTime", target = "startTime")
    @Mapping(source = "studyTime.deadline", target = "deadline")
    StudyArticleResponseDto studyArticleToStudyResponseDto(StudyArticle studyArticle);

    List<StudyArticleResponseDto> studyArticleListToStudyArticleResponseDtoList(List<StudyArticle> studyArticleList);

    @Mapping(source = "content", target = "studyContent.content")
    @Mapping(source = "meetTime", target = "studyInfo.meetTime")
    @Mapping(source = "purpose", target = "studyInfo.purpose")
    StudyArticle std(StudyArticleRequestDto s);


}
