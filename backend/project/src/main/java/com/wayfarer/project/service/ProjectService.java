package com.wayfarer.project.service;

import com.wayfarer.project.dto.*;

public interface ProjectService {

    void createProjectArticle(ProjectArticleRequestDto projectArticleRequestDto);

    ProjectArticleDetailResponseDto readProjectArticle(Long projectId);

    void updateProjectArticle(Long projectId, ProjectArticleUpdateRequestDto projectArticleUpdateRequestDto);

    void deleteProjectArticle(Long projectId);

    MultiResponseDto<ProjectArticleResponseDto> readAllProjectArticles(int page, Boolean status);


}
