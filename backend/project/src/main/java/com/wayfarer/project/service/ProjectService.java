package com.wayfarer.project.service;

import com.wayfarer.project.dto.*;

public interface ProjectService {

    void createProjectArticle(ProjectArticleRequestDto projectArticleRequestDto);

    ProjectArticleDetailResponseDto readProjectArticle(Long projectId);

    void updateProjectArticle(Long projectId, ProjectArticlePutRequestDto projectArticlePutRequestDto);

    void deleteProjectArticle(Long projectId);

    MultiResponseDto<ProjectArticleResponseDto> readAllProjectArticles(int page, Boolean status);


    MultiResponseDto<ProjectArticleResponseDto> readProjectArticlesWithTag(int page, String tag, Boolean status);
}
