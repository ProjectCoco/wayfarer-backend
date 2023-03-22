package com.wayfarer.project.service;


import com.wayfarer.common.dto.MultiResponseDto;
import com.wayfarer.common.dto.PageInfo;
import com.wayfarer.project.dto.*;
import com.wayfarer.project.entity.ProjectArticle;
import com.wayfarer.project.entity.ProjectMember;
import com.wayfarer.project.entity.enummodel.ProjectArticleEnum;
import com.wayfarer.project.entity.enummodel.ProjectStatus;
import com.wayfarer.project.entity.vo.ProjectInfo;
import com.wayfarer.project.mapper.ProjectMapper;
import com.wayfarer.project.mapper.ProjectMemberMapper;
import com.wayfarer.project.repository.ProjectArticleRepository;
import com.wayfarer.project.repository.ProjectMemberRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Primary
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectArticleRepository projectArticleRepository;
    private final ProjectMemberRepository projectMemberRepository;
    private final ProjectMapper projectMapper;
    private final ProjectMemberMapper projectMemberMapper;

    public ProjectServiceImpl(ProjectArticleRepository projectArticleRepository,
                              ProjectMemberRepository projectMemberRepository,
                              ProjectMapper projectMapper,
                              ProjectMemberMapper projectMemberMapper) {
        this.projectArticleRepository = projectArticleRepository;
        this.projectMemberRepository = projectMemberRepository;
        this.projectMapper = projectMapper;
        this.projectMemberMapper = projectMemberMapper;
    }

    @Override
    public void createProjectArticle(ProjectArticleRequestDto projectArticleRequestDto) {
        ProjectArticle projectArticle = saveProjectArticle(projectArticleRequestDto);
        List<String> projectMemberIds = createProjectMember(projectArticleRequestDto, projectArticle.getProjectArticleId());
        putProjectArticleMember(projectArticle, projectMemberIds);
    }

    private void putProjectArticleMember(ProjectArticle projectArticle, List<String> projectMemberIds) {
        projectArticle.setProjectMembers(projectMemberIds);
        projectArticleRepository.save(projectArticle);
    }

    private List<String> createProjectMember(ProjectArticleRequestDto projectArticleRequestDto, Long savedProjectArticleId) {
        List<String> projectMemberIds = new ArrayList<>();
        for (ProjectMemberRequestDto projectMemberRequestDto : projectArticleRequestDto.getProjectMember()) {
            ProjectMemberDto projectMemberDto = ProjectMemberDto.builder()
                    .projectArticleId(savedProjectArticleId)
                    .totalMember(projectMemberRequestDto.getTotalMember())
                    .countMember(0)
                    .position(projectMemberRequestDto.getPosition())
                    .build();
            ProjectMember projectMember = projectMemberRepository.save(projectMemberMapper.projectMemberDtoToProjectMember(projectMemberDto));
            projectMemberIds.add(String.valueOf(projectMember.getProjectMemberId()));
        }
        return projectMemberIds;
    }

    private ProjectArticle saveProjectArticle(ProjectArticleRequestDto projectArticleRequestDto) {
        ProjectArticle projectArticle = projectMapper.projectRequestDtoToProjectArticle(projectArticleRequestDto);
        projectArticle.initProjectArticle();
        projectArticleRepository.save(projectArticle);
        return projectArticle;
    }

    @Override
    public MultiResponseDto<ProjectArticleResponseDto> readAllProjectArticles(int page, Boolean status) {
        Page<ProjectArticle> projectArticleList = null;
        if (status) {
            projectArticleList = projectArticleRepository
                    .findByEnabledAndProjectInfo(true, new ProjectInfo(ProjectStatus.PROCEED), PageRequest.of(page - 1, 9, Sort.by(ProjectArticleEnum.PROJECT_ARTICLE_ID.getValue()).descending()));
        }

        if (!status) {
            projectArticleList = projectArticleRepository
                    .getByEnabled(true, PageRequest.of(page - 1, 9, Sort.by(ProjectArticleEnum.PROJECT_ARTICLE_ID.getValue()).descending()));
        }
        return new MultiResponseDto<>(joinProjectMember(projectArticleList.getContent()), new PageInfo(projectArticleList.getNumber() + 1, projectArticleList.getSize(), projectArticleList.getTotalElements(), projectArticleList.getTotalPages()));
    }

    @Override
    public MultiResponseDto<ProjectArticleResponseDto> readProjectArticlesWithTag(int page, String tag, Boolean status) {
        Page<ProjectArticle> projectArticleListWithTag = null;
        if (status) {
            projectArticleListWithTag = projectArticleRepository
                    .findByProjectTagsContainsAndEnabledAndProjectInfo(tag, true,
                            new ProjectInfo(ProjectStatus.PROCEED),
                            PageRequest.of(page - 1, 9, Sort.by(ProjectArticleEnum.PROJECT_ARTICLE_ID.getValue()).descending()));
        }
        if (!status) {
            projectArticleListWithTag = projectArticleRepository
                    .findByProjectTagsContainsAndEnabled(tag, true,
                            PageRequest.of(page - 1, 9, Sort.by(ProjectArticleEnum.PROJECT_ARTICLE_ID.getValue()).descending()));
        }
        return new MultiResponseDto<>(joinProjectMember(projectArticleListWithTag.getContent()), new PageInfo(projectArticleListWithTag.getNumber() + 1, projectArticleListWithTag.getSize(), projectArticleListWithTag.getTotalElements(), projectArticleListWithTag.getTotalPages()));
    }

    @Override
    public MultiResponseDto<ProjectArticleResponseDto> readProjectArticlesWithSkills(int page, SkillParamDto skillParamDto, ProjectStatus status) {
        Page<ProjectArticle> projectArticles = projectArticleRepository
                .getAllBySkill(status, skillParamDto,
                        PageRequest.of(page - 1, 9, Sort.by(ProjectArticleEnum.PROJECT_ARTICLE_ID.getValue()).descending()));

        return new MultiResponseDto<>(joinProjectMember(projectArticles.getContent()), new PageInfo(projectArticles.getNumber() + 1, projectArticles.getSize(), projectArticles.getTotalElements(), projectArticles.getTotalPages()));
    }

    private List<ProjectArticleResponseDto> joinProjectMember(List<ProjectArticle> projectArticles) {
        return projectArticles.stream()
                .map(this::projectMemberListToEntity)
                .collect(Collectors.toList());
    }

    private ProjectArticleResponseDto projectMemberListToEntity(ProjectArticle projectArticle) {

        List<ProjectMemberResponseDto> projectMembers = projectArticle.getProjectMembers().stream()
                .map(memberId -> projectMemberRepository.findById(Long.valueOf(memberId)).orElseThrow())
                .map(projectMemberMapper::projectMemberToProjectMemberResponseDto)
                .collect(Collectors.toList());

        return projectMapper.projectArticleToProjectArticleResponseDto(projectArticle, projectMembers);
    }

    @Override
    public ProjectArticleDetailResponseDto readProjectArticle(Long projectId) {
        ProjectArticle projectArticle = projectArticleRepository.findById(projectId).orElseThrow(NullPointerException::new);
        List<ProjectMember> projectMembers = projectMemberRepository.findByProjectArticleId(projectArticle.getProjectArticleId());
        List<ProjectMemberResponseDto> projectMemberResponseDtos = projectMemberMapper.projectMembersToProjectMemberResponseDtos(projectMembers);

        return projectMapper.projectArticleToProjectArticleDetailResponseDto(projectArticle, projectMemberResponseDtos);
    }

    @Override
    public void updateProjectArticle(Long projectId, ProjectArticlePutRequestDto projectArticlePutRequestDto) {
        ProjectArticle projectArticle = projectArticleRepository.findById(projectId).orElseThrow();
        projectArticle.updateAll(projectArticlePutRequestDto);
        projectArticleRepository.save(projectArticle);

        updateProjectMembers(projectArticlePutRequestDto);
    }

    private void updateProjectMembers(ProjectArticlePutRequestDto projectArticlePutRequestDto) {
        projectArticlePutRequestDto.getProjectMembers().forEach(dto -> {
            ProjectMember projectMember = projectMemberRepository.findById(dto.getProjectMemberId()).orElseThrow();
            projectMember.setPosition(dto.getPosition());
            projectMember.setTotalMember(dto.getTotalMember());
            projectMember.setCountMember(dto.getCountMember());
        });
    }

    @Override
    public void deleteProjectArticle(Long projectId) {
        ProjectArticle projectArticle = projectArticleRepository.findById(projectId).orElseThrow(NullPointerException::new);
        projectArticle.changeEnabled(false);
        projectArticleRepository.save(projectArticle);
    }

    @Override
    public MultiResponseDto<ProjectArticleResponseDto> readAllPopularProjectArticles() {
        List<ProjectArticle> projectArticleList = projectArticleRepository.findByRandomArticles();
        return new MultiResponseDto<>(joinProjectMember(projectArticleList), null);
    }
}
