package com.wayfarer.study.mapper;

import com.wayfarer.study.dto.*;
import com.wayfarer.study.entity.StudyArticle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudyMapper {

    @Mapping(source = "studyArticle.studyContent.content", target = "content")
    @Mapping(source = "studyArticle.studyInfo.status", target = "status")
    @Mapping(source = "studyArticle.studyTime.startTime", target = "startTime")
    StudyArticleDetailResponseDto studyArticleToStudyDetailResponseDto(StudyArticle studyArticle, List<StudyMemberResponseDto> studyMemberResponses);

    @Mapping(source = "studyArticle.studyInfo.status", target = "status")
    StudyArticleResponseDto studyArticleToStudyResponseDto(StudyArticle studyArticle, List<StudyMemberResponseDto> studyMemberResponses);

    List<StudyArticleResponseDto> studyArticleListToStudyArticleResponseDtoList(List<StudyArticle> studyArticleList);

    @Mapping(source = "content", target = "studyContent.content")
    @Mapping(source = "startTime", target = "studyTime.startTime")
    StudyArticle studyRequestDtoToStudyArticle(StudyArticleRequestDto studyArticleRequestDto);


}
