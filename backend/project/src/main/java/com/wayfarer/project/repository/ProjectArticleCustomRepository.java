package com.wayfarer.project.repository;

import com.wayfarer.project.entity.ProjectArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProjectArticleCustomRepository {

    Page<ProjectArticle> getAll(Pageable pageable);
    
    Page<ProjectArticle> getAllBySkill(String skill, Pageable pageable);
}
