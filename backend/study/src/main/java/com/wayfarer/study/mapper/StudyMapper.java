package com.wayfarer.study.mapper;

import com.wayfarer.study.dto.StudyArticleRequestDto;
import com.wayfarer.study.dto.StudyDetailResponseDto;
import com.wayfarer.study.entity.StudyArticle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudyMapper {

    @Mapping(source = "studyContent.content", target = "content")
    @Mapping(source = "studyInfo.purpose", target = "purpose")
    @Mapping(source = "studyInfo.meetTime", target = "meetTime")
    StudyDetailResponseDto studyArticleToStudyDetailResponseDto(StudyArticle studyArticle);

    @Mapping(source = "content", target = "studyContent.content")
    @Mapping(source = "meetTime", target = "studyInfo.meetTime")
    @Mapping(source = "purpose", target = "studyInfo.purpose")
    StudyArticle std(StudyArticleRequestDto s);


}
