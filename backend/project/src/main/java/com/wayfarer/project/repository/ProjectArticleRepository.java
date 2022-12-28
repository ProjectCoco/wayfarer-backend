package com.wayfarer.project.repository;

import com.wayfarer.project.entity.ProjectArticle;
import com.wayfarer.project.entity.vo.ProjectInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectArticleRepository extends JpaRepository<ProjectArticle, Long>, ProjectArticleCustomRepository {


    Page<ProjectArticle> findByEnabled(Boolean enabled, Pageable pageable);

    Page<ProjectArticle> findByEnabledAndProjectInfo(boolean enabled, ProjectInfo projectInfo, Pageable pageable);

    Page<ProjectArticle> findByProjectTagsContainsAndEnabledAndProjectInfo(String tag, boolean enabled, ProjectInfo projectInfo, Pageable pageable);

    Page<ProjectArticle> findByProjectTagsContainsAndEnabled(String tag, boolean enabled, Pageable pageable);
}
