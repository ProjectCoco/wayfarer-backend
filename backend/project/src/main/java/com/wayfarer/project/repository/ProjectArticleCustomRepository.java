package com.wayfarer.project.repository;

import com.wayfarer.project.dto.SkillParamDto;
import com.wayfarer.project.entity.ProjectArticle;
import com.wayfarer.project.entity.enummodel.ProjectStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProjectArticleCustomRepository {

    Page<ProjectArticle> getAll(Pageable pageable);
    
    Page<ProjectArticle> getAllBySkill(ProjectStatus projectStatus, SkillParamDto skillParamDto, Pageable pageable);
}
