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

    @Mapping(source = "projectSkill", target = "projectSkill.skillId")
    @Mapping(source = "content", target = "projectContent.content")
    @Mapping(source = "startTime", target = "projectTime.startTime")
    @Mapping(source = "totalMember", target = "projectMember.totalMember")
    ProjectArticle projectRequestDtoToProjectArticle(ProjectArticleRequestDto projectArticleRequestDto);

    @Mapping(source = "projectContent.content", target = "content")
    @Mapping(source = "projectInfo.status", target = "status")
    @Mapping(source = "projectTime.startTime", target = "startTime")
    @Mapping(source = "projectMember.totalMember", target = "totalMember")
    @Mapping(source = "projectMember.countMember", target = "countMember")
    ProjectArticleResponseDto projectArticleToProjectArticleResponseDto(ProjectArticle projectArticle);

    @Mapping(source = "projectContent.content", target = "content")
    @Mapping(source = "projectInfo.status", target = "status")
    @Mapping(source = "projectTime.startTime", target = "startTime")
    @Mapping(source = "projectMember.totalMember", target = "totalMember")
    @Mapping(source = "projectMember.countMember", target = "countMember")
    ProjectArticleDetailResponseDto projectArticleToProjectArticleDetailResponseDto(ProjectArticle projectArticle);

    List<ProjectArticleResponseDto> projectArticleListToProjectArticleResponseDtoList(List<ProjectArticle> content);
}