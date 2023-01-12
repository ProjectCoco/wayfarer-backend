package com.wayfarer.project.mapper;

import com.wayfarer.project.dto.ProjectArticleDetailResponseDto;
import com.wayfarer.project.dto.ProjectArticleRequestDto;
import com.wayfarer.project.dto.ProjectArticleResponseDto;
import com.wayfarer.project.entity.ProjectArticle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    @Mapping(source = "content", target = "projectContent.content")
    @Mapping(source = "startTime", target = "projectTime.startTime")
    ProjectArticle projectRequestDtoToProjectArticle(ProjectArticleRequestDto projectArticleRequestDto);

    @Mapping(source = "projectInfo.status", target = "status")
    @Mapping(source = "projectTime.startTime", target = "startTime")
    ProjectArticleResponseDto projectArticleToProjectArticleResponseDto(ProjectArticle projectArticle);

    @Mapping(source = "projectContent.content", target = "content")
    @Mapping(source = "projectInfo.status", target = "status")
    @Mapping(source = "projectTime.startTime", target = "startTime")
    ProjectArticleDetailResponseDto projectArticleToProjectArticleDetailResponseDto(ProjectArticle projectArticle);

    List<ProjectArticleResponseDto> projectArticleListToProjectArticleResponseDtoList(List<ProjectArticle> content);
}