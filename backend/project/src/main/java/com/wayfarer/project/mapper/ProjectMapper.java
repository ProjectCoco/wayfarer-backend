package com.wayfarer.project.mapper;

import com.wayfarer.project.dto.ProjectArticleDetailResponseDto;
import com.wayfarer.project.dto.ProjectArticleRequestDto;
import com.wayfarer.project.dto.ProjectArticleResponseDto;
import com.wayfarer.project.entity.ProjectArticle;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectArticle projectRequestDtoToProjectArticle(ProjectArticleRequestDto projectArticleRequestDto);

    ProjectArticleDetailResponseDto projectArticleToProjectArticleDetailResponseDto(ProjectArticle projectArticle);

    List<ProjectArticleResponseDto> projectArticleListToProjectArticleResponseDtoList(List<ProjectArticle> content);
}
