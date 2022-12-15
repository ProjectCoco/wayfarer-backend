package com.wayfarer.project.service;


import com.wayfarer.project.dto.*;
import com.wayfarer.project.entity.ProjectArticle;
import com.wayfarer.project.mapper.ProjectMapper;
import com.wayfarer.project.repository.ProjectArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Primary
@Service
@RequiredArgsConstructor
@Transactional
public class ProjectArticleServiceImpl implements ProjectArticleService {

    private final ProjectArticleRepository projectArticleRepository;
    private final ProjectMapper projectMapper;

    @Override
    public void createProjectArticle(ProjectArticleRequestDto projectArticleRequestDto) {
        ProjectArticle projectArticle = projectMapper.projectRequestDtoToProjectArticle(projectArticleRequestDto);
        projectArticle.initStudyArticle();
        projectArticleRepository.save(projectArticle);

    }

    @Override
    public MultiResponseDto<ProjectArticleResponseDto> readAllProjectArticles(int page, Boolean status) {
        return null;
    }

    @Override
    public ProjectArticleDetailResponseDto readProjectArticle(Long projectId) {
        ProjectArticle projectArticle = projectArticleRepository.findById(projectId).orElseThrow(NullPointerException::new);
        return projectMapper.projectArticleToProjectArticleDetailResponseDto(projectArticle);
    }

    @Override
    public void updateProjectArticle(Long projectId, ProjectArticleUpdateRequestDto projectArticleUpdateRequestDto) {

    }

    @Override
    public void deleteProjectArticle(Long projectId) {
        ProjectArticle projectArticle = projectArticleRepository.findById(projectId).orElseThrow(NullPointerException::new);
        projectArticle.changeEnabled(false);
        projectArticleRepository.save(projectArticle);
    }


}
