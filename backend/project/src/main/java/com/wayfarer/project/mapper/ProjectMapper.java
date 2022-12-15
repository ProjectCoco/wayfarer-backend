package com.wayfarer.project.mapper;

import com.wayfarer.project.dto.ProjectArticleDetailResponseDto;
import com.wayfarer.project.dto.ProjectArticleRequestDto;
import com.wayfarer.project.entity.ProjectArticle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectArticle projectRequestDtoToProjectArticle(ProjectArticleRequestDto projectArticleRequestDto);

    ProjectArticleDetailResponseDto projectArticleToProjectArticleDetailResponseDto(ProjectArticle projectArticle);
}
