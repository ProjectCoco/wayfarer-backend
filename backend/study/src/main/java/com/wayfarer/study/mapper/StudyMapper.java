package com.wayfarer.study.mapper;

import com.wayfarer.study.dto.StudyArticleDetailResponseDto;
import com.wayfarer.study.dto.StudyArticleRequestDto;
import com.wayfarer.study.dto.StudyArticleResponseDto;
import com.wayfarer.study.entity.StudyArticle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StudyMapper {

    @Mapping(source = "studyContent.content", target = "content")
    @Mapping(source = "studyInfo.active", target = "active")
    @Mapping(source = "studyTime.startTime", target = "startTime")
    @Mapping(source = "studyTime.deadline", target = "deadline")
    @Mapping(source = "studyMember.totalMember", target = "totalMember")
    @Mapping(source = "studyMember.countMember", target = "countMember")
    StudyArticleDetailResponseDto studyArticleToStudyDetailResponseDto(StudyArticle studyArticle);

    @Mapping(source = "studyInfo.active", target = "active")
    @Mapping(source = "studyTime.startTime", target = "startTime")
    @Mapping(source = "studyTime.deadline", target = "deadline")
    @Mapping(source = "studyMember.totalMember", target = "totalMember")
    @Mapping(source = "studyMember.countMember", target = "countMember")
    StudyArticleResponseDto studyArticleToStudyResponseDto(StudyArticle studyArticle);

    List<StudyArticleResponseDto> studyArticleListToStudyArticleResponseDtoList(List<StudyArticle> studyArticleList);

    @Mapping(source = "content", target = "studyContent.content")
    @Mapping(source = "startTime", target = "studyTime.startTime")
    @Mapping(source = "deadline", target = "studyTime.deadline")
    @Mapping(source = "totalMember", target = "studyMember.totalMember")
    @Mapping(source = "positionName", target = "studyPosition.positionName")
    StudyArticle studyRequestDtoToStudyArticle(StudyArticleRequestDto studyArticleRequestDto);


}
