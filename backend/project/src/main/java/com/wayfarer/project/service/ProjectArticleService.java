package com.wayfarer.project.service;

public interface ProjectArticleService {

    void createProjectArticle(ProjectArticleRequestDto projectArticleRequestDto);

    MultiResponseDto<ProjectArticleDetailResponseDto> readProjectArticle(int page);

    void updateProjectArticle(Long projectId, ProjectArticleUpdateRequestDto projectArticleUpdateRequestDto);

    void deleteProjectArticle(Long projectId);


}
